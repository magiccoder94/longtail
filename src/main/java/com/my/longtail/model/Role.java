package com.my.longtail.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
	
	public static final String ROLE_MANAGEMEN = "ROLE_MANAGEMENT";
	
	public static final String ROLE_INVESTOR = "ROLE_INVESTOR";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	public Role() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
