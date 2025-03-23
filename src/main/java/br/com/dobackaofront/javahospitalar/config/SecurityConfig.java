package br.com.dobackaofront.javahospitalar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        // .requestMatchers("/auth/**").hasAuthority("ADMIN") // isso é unitil a primeira vez que executa a aplicacao
                        .requestMatchers("/auth/register-admin").denyAll() // Bloqueia cadastro de admin via API pública - // .requestMatchers("/auth/register-admin").permitAll() // Permitir Acesso sem autenticacao para cadastrar usuario admin
                        .requestMatchers("/recepcionista/**").hasAuthority("RECEPCIONISTA")
                        .requestMatchers("/medico/**").hasAuthority("MEDICO")
                        .requestMatchers("/enfermeiro/**").hasAuthority("ENFERMEIRO")
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
