package com.ie.notes.controller;

import com.ie.notes.mapper.UserMapper;
import com.ie.notes.model.User;
import com.ie.notes.model.dto.UserCreateDto;
import com.ie.notes.model.dto.UserDto;
import com.ie.notes.service.UserService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping("/{username}")
  public Mono<User> get(@PathVariable("username") String username) {
    return userService.getByUserName(username);
  }

  @PutMapping("/{username}")
  public Mono<User> update(
      @PathVariable("username") String username,
      @RequestBody UserDto userDto
  ) {
//    userService.getByUserName(username)
//        .switchIfEmpty(Mono.defer(() -> Mono.error(new RuntimeException())))
//        .map(value -> UserMapper.INSTANCE.map(userDto))
//        .(value -> value.setUpdateDate(LocalDateTime.now()))
//    ;
    User user = UserMapper.INSTANCE.map(userDto);
    user.setUpdateDate(LocalDateTime.now());
    return userService.save(user);
  }

  @PostMapping
  public Mono<User> save(@RequestBody UserCreateDto userDto) {
    User user = UserMapper.INSTANCE.map(userDto);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setCreateDate(LocalDateTime.now());
    user.setUpdateDate(LocalDateTime.now());
    return userService.save(user);
  }
}
