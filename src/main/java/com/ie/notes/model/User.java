package com.ie.notes.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "user")
public class User {

  @Id
  private UUID id;
  private String username;
  private String name;
  private String password;
  private boolean isEnabled;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;
  private Collection<String> roles;

  private LocalDateTime expireDate;
  private LocalDateTime passwordExpireDate;
}
