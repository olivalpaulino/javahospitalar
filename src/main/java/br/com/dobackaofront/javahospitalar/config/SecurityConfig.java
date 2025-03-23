package br.com.dobackaofront.javahospitalar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
                        .requestMatchers("/recepcionista/**").hasAuthority("RECEPCIONISTA")
                        .requestMatchers("/medico/**").hasAuthority("MEDICO")
                        .requestMatchers("/enfermeiro/**").hasAuthority("ENFERMEIRO")
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(login -> login
                        .loginPage("/login")  // Rota personalizada para a página de login
                        .defaultSuccessUrl("/", true) // Redireciona após login bem-sucedido
                        .permitAll()  // Permite que todos acessem a página de login
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")  // Rota para logout
                        .logoutSuccessUrl("/login?logout")  // Redireciona após logout
                        .invalidateHttpSession(true)  // Invalida a sessão
                        .deleteCookies("JSESSIONID")  // Remove cookies
                );

        return http.build();
    }
}
