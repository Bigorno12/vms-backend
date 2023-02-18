package com.pacdesign.service.mapper;

import com.pacdesign.persistence.entity.User;
import com.pacdesign.service.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapToEntity(UserDto userDto);

    UserDto mapToDto(User user);
}
