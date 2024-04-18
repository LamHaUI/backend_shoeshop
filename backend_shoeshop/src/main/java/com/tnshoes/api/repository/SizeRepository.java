package com.tnshoes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnshoes.api.entity.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long>{

}
