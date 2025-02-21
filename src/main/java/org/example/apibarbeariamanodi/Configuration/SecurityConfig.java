package org.example.apibarbeariamanodi.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",  // Swagger UI
                                "/v3/api-docs/**", // Documentação OpenAPI
                                "/swagger-ui.html" // Página inicial do Swagger
                        ).permitAll() // Permite acesso sem autenticação
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()) // Desativa CSRF para testes com Swagger
                .formLogin(form -> form.disable()) // Desativa login via formulário
                .httpBasic(httpBasic -> httpBasic.disable()); // Desativa autenticação básica

        return http.build();
    }
}
