package com.tnshoes.api.entity;

import com.tnshoes.api.entity.composite_key.ReceiptDetailId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(ReceiptDetailId.class)
@Table(name = "receipt_details")
public class ReceiptDetail {

	@Id
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Receipt receipt;

	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductItem product;
	
	private Long quantity;
	
	private Double cost;
}
