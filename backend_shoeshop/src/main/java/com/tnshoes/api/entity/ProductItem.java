package com.tnshoes.api.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.NaturalId;

import com.tnshoes.api.entity.composite_key.ProductItemId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_items")
public class ProductItem implements Serializable{

	@Id
	@GeneratedValue
	private UUID id;
	
	@NaturalId
	@Embedded
	private ProductItemId productItemId;
	
	@ManyToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;
	
	private Long quantity;
	
	@Column(name = "price_retail")
	private Double priceRetail;
	
	private Boolean isDeleted;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderDetail> orderDetails;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProductImage> productImages;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ReceiptDetail> receiptDetails;
}
