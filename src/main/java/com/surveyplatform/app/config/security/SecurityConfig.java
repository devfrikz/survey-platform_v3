package com.surveyplatform.app.config.security;

import com.surveyplatform.app.controller.handler.CustomAuthenticationFailureHandler;
import com.surveyplatform.app.persistance.repository.UsuarioRepository;
import com.surveyplatform.app.service.CustomUserDetailsService;
import com.surveyplatform.app.service.impl.CustomUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    private final UsuarioRepository usuarioRepository;

    // Definimos rutas abiertas (públicas) y protegidas
    private static final String[] WHITE_LIST = {
            "/login",
            "/register",
            "/error"
    };

    private static final String[] AUTHENTICATED_LIST = {
            "/",
            "/index",
            "/login-success"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> {
                    // Rutas públicas, accesibles sin autenticación
                    auth.requestMatchers(WHITE_LIST).permitAll();

                    // Rutas protegidas por roles específicos
                    auth.requestMatchers("/approvals").hasRole("GERENTE")  // Solo gerentes acceden a aprobaciones
                            .requestMatchers("/daily-planner", "/customer-needs").hasRole("VENTAS")  // Solo ventas accede a estos

                            // Otras rutas que requieren autenticación
                            .requestMatchers(AUTHENTICATED_LIST).authenticated()
                            .anyRequest().authenticated();
                })
                .formLogin(form -> form
                        .loginPage("/login")
                        .failureHandler(customAuthenticationFailureHandler)  // Handler personalizado para errores de login
                        .defaultSuccessUrl("/login-success", true)  // Redirige tras login exitoso
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                )
                .sessionManagement(sess -> sess
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                );

        return http.build();
    }

    // Configuración de PasswordEncoder usando BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Implementación personalizada de UserDetailsService para autenticar usuarios
    @Bean
    @Primary
    public CustomUserDetailsService userDetailsService() {
        return new CustomUserDetailsServiceImpl(usuarioRepository);
    }

    // Configuración de AuthenticationManager con UserDetailsService y PasswordEncoder
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}
