package com.ie.notes.config;

import com.ie.notes.service.UserNotesDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

  @Autowired
  private UserNotesDetailsService userDetailsService;

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(
      ServerHttpSecurity http) {
    http.csrf().disable()
        .formLogin()
        .and()
        .authorizeExchange()
        .pathMatchers(HttpMethod.GET, "/login").permitAll()
        .pathMatchers(HttpMethod.POST, "/login").permitAll()
        .pathMatchers(HttpMethod.POST, "/user").permitAll()
        .pathMatchers("/**").hasRole("USER")
        .and()
        .httpBasic();
    return http.build();
  }

  @Bean
  public ReactiveAuthenticationManager authenticationManager() {
    UserDetailsRepositoryReactiveAuthenticationManager manager =
        new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
    manager.setPasswordEncoder(passwordEncoder());
    return manager;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new Pbkdf2PasswordEncoder("long main word");
  }
}
