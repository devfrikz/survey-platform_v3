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
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
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
    private final CustomUserDetailsService customUserDetailsService;

    private static final String[] WHITE_LIST = {
            "/login",
            "/register",
            "/error"
    };

    private static final String[] GENERAL_LIST = {
            "/",
            "/index",
            "/login-success"
    };

    private static final String[] ADMIN_LIST = {
            "/approvals",
            "/daily-planner",
            "/customer-needs"
    };

    private static final String[] GERENTE_LIST = {
            "/approvals"
    };

    private static final String[] VENTAS_LIST = {
            "/daily-planner",
            "/customer-needs"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(WHITE_LIST).permitAll();
                    auth
                            .requestMatchers(ADMIN_LIST).hasRole("ADMIN")  // Admin puede acceder sin restricciones
                            .requestMatchers(GERENTE_LIST).hasRole("GERENTE")  // Solo gerentes acceden a aprobaciones
                            .requestMatchers(VENTAS_LIST).hasRole("VENTAS")  // Solo ventas accede a estos
                            .requestMatchers(GENERAL_LIST).authenticated()
                            .anyRequest().authenticated();
                })
                .formLogin(form -> form
                        .loginPage("/login")
                        .failureHandler(customAuthenticationFailureHandler)  // Handler personalizado para errores de login
                        .defaultSuccessUrl("/login-success", true)  // Redirige tras login exitoso
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll)
                .sessionManagement(sess -> sess
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Primary
    public CustomUserDetailsService userDetailsService() {
        return new CustomUserDetailsServiceImpl(usuarioRepository);
    }

//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        return authenticationManagerBuilder.build();
//    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setHideUserNotFoundExceptions(false);

        return new ProviderManager(authProvider);
    }
}
