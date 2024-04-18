package com.tnshoes.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnshoes.api.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, UUID>{

}
