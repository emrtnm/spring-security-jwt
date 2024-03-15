package com.emrtnm.jwt.mapper;

import com.emrtnm.jwt.dto.SignUpDto;
import com.emrtnm.jwt.dto.UserDto;
import com.emrtnm.jwt.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
