package com.ie.notes.mapper;

import com.ie.notes.model.User;
import com.ie.notes.model.dto.UserCreateDto;
import com.ie.notes.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  User map(UserCreateDto source);

  UserDto map(User source);

  User map(UserDto source);
}
