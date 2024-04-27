package com.tnshoes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnshoes.api.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, String>{

}
