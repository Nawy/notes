package com.ie.notes.controller;

import com.ie.notes.model.User;
import com.ie.notes.service.UserService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  @GetMapping("/{userId}")
  public Mono<User> get(@PathVariable("userId") UUID userId) {
    return userService.get(userId);
  }

  @PostMapping
  public Mono<User> save(@RequestBody User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userService.save(user);
  }
}
