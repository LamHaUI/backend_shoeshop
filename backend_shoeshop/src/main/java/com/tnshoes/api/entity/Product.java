package com.tnshoes.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String name; 
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@JoinColumn(name = "publish_time")
	private LocalDateTime publishTime;
	
	private String description;

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
	
	@ManyToMany(mappedBy = "favoriteProducts",fetch = FetchType.EAGER)
	private Set<User> customers;
}
