package com.tnshoes.api.entity;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_prices")
public class ProductPrice {

	@Id
	@GeneratedValue
	private UUID id;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "product_id"),
		@JoinColumn(name = "size_id"),
		@JoinColumn(name = "color_id")
	})
	private ProductItem product;
	
	@JoinColumn(name = "price_retail")
	private Double priceRetail;

	@JoinColumn(name = "deleted")
	private Boolean isDeleted;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderDetail> orderDetails;
}
