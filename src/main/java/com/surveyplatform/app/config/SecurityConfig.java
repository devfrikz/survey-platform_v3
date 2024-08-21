package com.surveyplatform.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class SecurityConfig {

    private final String[] whiteList = {
            "/login",
            "/register",
            "/error",
            "/env-check"
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

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("admin@test.com")
                        .password("admin")
                        .roles("ROOT")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
