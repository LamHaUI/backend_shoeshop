package com.tnshoes.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnshoes.api.entity.ProductItem;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, UUID>{

}
