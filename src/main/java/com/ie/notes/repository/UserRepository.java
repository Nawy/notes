package com.ie.notes.repository;


import com.ie.notes.model.User;
import java.util.UUID;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, UUID> {

  Mono<User> getUserByUsername(String username);
}
