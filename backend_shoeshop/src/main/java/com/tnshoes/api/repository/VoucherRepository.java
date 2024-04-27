package com.tnshoes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnshoes.api.entity.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, String>{

}
