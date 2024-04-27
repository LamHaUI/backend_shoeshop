package com.tnshoes.api.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "roles")
public class Role {

	@Id
	private String name;
	
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_permissions",
    	joinColumns = @JoinColumn(name = "role_id"),
    	inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private Set<Permission> permissions;
	
	@ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
	private Set<User> users;
}
