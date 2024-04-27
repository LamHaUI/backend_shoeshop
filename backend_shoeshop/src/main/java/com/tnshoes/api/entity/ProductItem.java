package com.tnshoes.api.entity;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.NaturalId;

import com.tnshoes.api.entity.composite_key.ProductItemId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "product_items")
public class ProductItem implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
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
	private Set<FileDB> productImages;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ReceiptDetail> receiptDetails;
}
