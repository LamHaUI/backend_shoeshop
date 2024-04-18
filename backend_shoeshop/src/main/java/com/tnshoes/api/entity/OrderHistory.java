package com.tnshoes.api.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.tnshoes.api.common.OrderAction;
import com.tnshoes.api.entity.composite_key.OrderHistoryId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@IdClass(OrderHistoryId.class)
@Table(name = "order_historys")
public class OrderHistory {

	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Id
	@Enumerated(EnumType.STRING) 
	@JoinColumn(name = "action")
	private OrderAction action;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_time")
	private LocalDateTime creationTime;
	
	@ManyToOne
	@JoinColumn(name = "creater_id")
	private User creater;
	
	private String description;
}
