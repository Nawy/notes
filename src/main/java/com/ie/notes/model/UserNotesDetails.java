package com.ie.notes.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@RequiredArgsConstructor
public class UserNotesDetails implements UserDetails {

  private final User user;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return user.getRoles().stream()
        .map(UserAuthority::new)
        .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return user.getExpireDate() == null || user.getExpireDate().isBefore(LocalDateTime.now());
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return user.getPasswordExpireDate() == null || user.getPasswordExpireDate()
        .isBefore(LocalDateTime.now());
  }

  @Override
  public boolean isEnabled() {
    return user.isEnabled();
  }

  @RequiredArgsConstructor
  static class UserAuthority implements GrantedAuthority {

    private final String name;

    @Override
    public String getAuthority() {
      return name;
    }
  }
}
