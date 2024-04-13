package com.tnshoes.api.entity;

import com.tnshoes.api.entity.composite_key.ReceiptDetailId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
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
	@JoinColumns({
		@JoinColumn(name = "product_id"),
		@JoinColumn(name = "size_id"),
		@JoinColumn(name = "color_id")
	})
	private ProductItem product;
	
	private Long quantity;
	
	private Double cost;
}
