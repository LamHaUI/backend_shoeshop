package com.tnshoes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnshoes.api.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long>{

}
