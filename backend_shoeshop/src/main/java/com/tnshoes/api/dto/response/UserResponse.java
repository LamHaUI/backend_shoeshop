package com.tnshoes.api.dto.response;

import java.util.Set;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
	
	UUID id;
    String email;
    String phone;
    String avatar;
    String name;
    Set<RoleResponse> roles;
}
