package com.tnshoes.api.entity;

import java.time.LocalDateTime;
import java.util.Set;

import com.tnshoes.api.common.TypeValue;

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
@Table(name = "sales")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String name;
	
	@JoinColumn(name = "start_time")
	private LocalDateTime startTime;

	@JoinColumn(name = "finish_time")
	private LocalDateTime finishTime;
	
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "type")
	private TypeValue type;
	
	private Double value;
	
	@ManyToOne
	@JoinColumn(name = "creater_id")
	private User creater;
	
	@OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProductItem> productItems;
}
