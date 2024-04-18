package com.tnshoes.api.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private UUID id;

	private String name;

	private String avatar;

	@NaturalId
    @Column(nullable = false)
	private String email;

	@NaturalId
    @Column(nullable = false)
	private Integer phone;

    @Column(nullable = false)
	private String password;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_time")
	private LocalDateTime creationTime;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	private LocalDateTime updateTime;

	@ManyToOne
	@JoinColumn(name = "creater_id")
	private User creater;

	@ManyToOne
	@JoinColumn(name = "updater_id")
	private User updater;

	@JoinColumn(name = "deleted")
	private Boolean isDeleted;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Order> orders;
	
	@OneToMany(mappedBy = "creater", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderHistory> orderHistorys;

	@OneToMany(mappedBy = "creater", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Product> productsCreated;

	@OneToMany(mappedBy = "updater", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Product> productsUpdated;
	
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Receipt> receipts;

	@OneToMany(mappedBy = "creater", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Sale> salesCreated;
	
	@OneToMany(mappedBy = "creater", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<User> usersCreated;

	@OneToMany(mappedBy = "updater", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<User> usersUpdated;
	
	@OneToMany(mappedBy = "creater", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Voucher> vouchersCreated;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "voucher_customer", 
			joinColumns = @JoinColumn(name = "customer_id"), 
			inverseJoinColumns = @JoinColumn(name = "voucher_id"))
	private Set<Voucher> vouchers;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "favorite_products", 
			joinColumns = @JoinColumn(name = "customer_id"), 
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<Product> favoriteProducts;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_user", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
}
