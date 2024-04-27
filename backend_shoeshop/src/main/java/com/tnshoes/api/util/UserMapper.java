package com.tnshoes.api.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.tnshoes.api.dto.request.UserCreationRequest;
import com.tnshoes.api.dto.request.UserUpdateRequest;
import com.tnshoes.api.dto.response.UserResponse;
import com.tnshoes.api.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
