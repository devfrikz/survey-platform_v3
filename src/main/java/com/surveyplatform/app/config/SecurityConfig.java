package com.surveyplatform.app.config;

import com.surveyplatform.app.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class SecurityConfig {

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
                    auth.requestMatchers(authenticatedList).hasAnyRole("ROOT").anyRequest().authenticated();
                })
                .formLogin(form -> form
                        .loginPage("/login")
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
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Fragmento de código comentado: Usuario en memoria para pruebas
        /*
        UserDetails user =
                User.builder()
                        .username("admin@test.com")
                        .password(passwordEncoder.encode("admin"))
                        .roles("ROOT")
                        .build();

        return new InMemoryUserDetailsManager(user);
        */

        // Comentado para usar la base de datos en lugar de usuarios en memoria
        // return new InMemoryUserDetailsManager();  // Aquí podrías dejarlo vacío si no quieres usar un usuario en memoria

        // Aquí se debe retornar la implementación personalizada del servicio que consulta la base de datos
        return new CustomUserDetailsService(); // Asegúrate de que esta clase está correctamente implementada
    }
}
