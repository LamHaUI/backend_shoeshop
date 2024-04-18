package com.tnshoes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnshoes.api.entity.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long>{

}
