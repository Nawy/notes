package com.ie.notes.model;

import java.time.LocalDateTime;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "user")
public class User {

  @Id
  private String username;
  private String email;
  private String name;
  private String password;
  private boolean isEnabled;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;
  private Collection<String> roles;

  private LocalDateTime expireDate;
  private LocalDateTime passwordExpireDate;
}
