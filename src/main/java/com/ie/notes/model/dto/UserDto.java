package com.ie.notes.model.dto;

import java.time.LocalDateTime;
import java.util.Collection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

  private String username;
  private String email;
  private String name;
  private boolean isEnabled;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;
  private Collection<String> roles;

  private LocalDateTime expireDate;
  private LocalDateTime passwordExpireDate;
}
