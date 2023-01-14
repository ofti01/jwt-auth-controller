package com.ofti.basicauthentification.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/products").hasAnyRole("ADMIN","USER")
                        .requestMatchers("/products/{id}").hasRole("ADMIN")
                        .anyRequest().denyAll()
                )
                .authenticationProvider(authenticationProvider)
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return  httpSecurity.build();
    }
}
