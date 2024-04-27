package com.tnshoes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnshoes.api.entity.InvalidatedToken;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String>{

}
