package com.ie.notes.controller;

import com.ie.notes.model.UserNotesDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import reactor.core.publisher.Mono;

public interface AuthController {
  default Mono<UserNotesDetails> auth(String username) {
    return ReactiveSecurityContextHolder.getContext()
        .map(SecurityContext::getAuthentication)
        .map(Authentication::getPrincipal)
        .map(value -> (UserNotesDetails) value)
        .filter(details -> details.getUsername().equalsIgnoreCase(username))
        .switchIfEmpty(Mono.defer(() -> Mono.error(new RuntimeException())));
  }

  default Mono<String> getUsername() {
    return ReactiveSecurityContextHolder.getContext()
        .map(SecurityContext::getAuthentication)
        .map(Authentication::getPrincipal)
        .map(value -> ((UserNotesDetails) value).getUsername())
        .switchIfEmpty(Mono.defer(() -> Mono.error(new RuntimeException())));
  }
}
