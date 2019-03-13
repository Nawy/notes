package com.ie.notes.service;

import com.ie.notes.model.User;
import com.ie.notes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public Mono<User> getByUserName(String username) {
    return userRepository.findById(username);
  }

  public Flux<User> findAll() {
    return userRepository.findAll();
  }

  public Mono<User> save(User user) {
    return userRepository.save(user);
  }
}
