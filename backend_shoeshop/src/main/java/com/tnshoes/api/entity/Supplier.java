package com.tnshoes.api.entity;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "suppliers")
public class Supplier {

	@Id
	@GeneratedValue
	private UUID id;

	private String name;

	private Integer taxcode;

	private String email;

	private Integer phone;

	@JoinColumn(name = "id_address")
	private String idAddress;
	
	@JoinColumn(name = "address")
	private String addressDetail;

	private String description;
	
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Receipt> receipts;
}
