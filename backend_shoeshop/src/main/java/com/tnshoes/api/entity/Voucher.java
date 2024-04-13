package com.tnshoes.api.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.tnshoes.api.common.TypeValue;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vouchers")
public class Voucher {

	@Id
	@GeneratedValue
	private UUID id;
		
	private String name;
	
	@JoinColumn(name = "start_time")
	private LocalDateTime startTime;

	@JoinColumn(name = "finish_time")
	private LocalDateTime finishTime;
	
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "type")
	private TypeValue type;
	
	private Double value;
	
	@JoinColumn(name = "value_apply")
	private Double valueApply;
	
	@ManyToOne
	@JoinColumn(name = "creater_id")
	private User creater;

	@OneToMany(mappedBy = "voucher", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Order> orders;
	
	@ManyToMany(mappedBy = "vouchers",fetch = FetchType.EAGER)
	private Set<User> customers;
}
