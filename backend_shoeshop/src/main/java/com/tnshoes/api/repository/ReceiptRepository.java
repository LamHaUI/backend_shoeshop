package com.tnshoes.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnshoes.api.entity.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, UUID>{

}
