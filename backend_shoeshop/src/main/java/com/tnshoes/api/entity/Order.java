package com.tnshoes.api.entity;

import java.util.Set;

import com.tnshoes.api.common.OrderStatus;
import com.tnshoes.api.common.PaymentMethod;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User customer;
	
	private String phone;

	@JoinColumn(name = "id_address")
	private String idAddress;
	
	@JoinColumn(name = "address")
	private String addressDetail;

	@JoinColumn(name = "price_ship")
	private Double priceShip;
	
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "payment_method")
	private PaymentMethod paymentMethod;

	@ManyToOne
	@JoinColumn(name = "voucher_id")
	private Voucher voucher;
	
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "status")
	private OrderStatus status; 
	
//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<OrderDetail> orderDetails;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderHistory> orderHistorys;

}
