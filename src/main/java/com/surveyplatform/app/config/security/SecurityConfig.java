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
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    private final UsuarioRepository usuarioRepository;

    private final String[] whiteList = {
            "/login",
            "/register",
            "/error"
    };
    private final String[] authenticatedList = {
            "/",
            "/index",
            "/login-success"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        http
                .authorizeHttpRequests(auth -> {
                    for (String pattern : whiteList) {
                        auth.requestMatchers(new MvcRequestMatcher(introspector, pattern)).permitAll();
                    }
                    auth.requestMatchers(authenticatedList).hasRole("ADMIN").anyRequest().authenticated();
                })
                .formLogin(form -> form
                        .loginPage("/login")
                        .failureHandler(customAuthenticationFailureHandler)  // Usa el handler personalizado
                        .defaultSuccessUrl("/login-success", true)
                        .permitAll()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    // Configuración del PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Primary
    public CustomUserDetailsService userDetailsService() {
        return new CustomUserDetailsServiceImpl(usuarioRepository);  // Implementación personalizada
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}
