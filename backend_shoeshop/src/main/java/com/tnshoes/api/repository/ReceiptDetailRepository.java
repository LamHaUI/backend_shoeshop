package com.tnshoes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnshoes.api.entity.ReceiptDetail;
import com.tnshoes.api.entity.composite_key.ReceiptDetailId;

@Repository
public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, ReceiptDetailId>{

}
