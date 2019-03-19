package com.ie.notes.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import reactor.core.publisher.Mono;

public class AuthSuccessHandler implements ServerAuthenticationSuccessHandler {

  @Override
  public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange,
      Authentication authentication) {
    return Mono.empty();
  }
}