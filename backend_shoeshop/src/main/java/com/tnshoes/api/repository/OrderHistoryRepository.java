package com.tnshoes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnshoes.api.entity.OrderHistory;
import com.tnshoes.api.entity.composite_key.OrderHistoryId;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, OrderHistoryId>{

}
