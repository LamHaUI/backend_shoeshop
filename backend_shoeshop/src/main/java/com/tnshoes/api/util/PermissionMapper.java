package com.tnshoes.api.util;

import org.mapstruct.Mapper;

import com.tnshoes.api.dto.request.PermissionRequest;
import com.tnshoes.api.dto.response.PermissionResponse;
import com.tnshoes.api.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}