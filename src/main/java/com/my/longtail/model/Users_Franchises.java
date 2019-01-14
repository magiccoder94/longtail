package com.my.longtail.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Users_Franchises implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user;
	private Franchise franchise;
	private Role role;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Franchise getFranchise() {
		return franchise;
	}
	public void setFranchise(Franchise franchise) {
		this.franchise = franchise;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
