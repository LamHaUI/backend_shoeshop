package com.tnshoes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnshoes.api.entity.OrderDetail;
import com.tnshoes.api.entity.composite_key.OrderDetailId;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId>{

}
