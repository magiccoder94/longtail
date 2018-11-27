package com.my.longtail.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "first_name", columnDefinition = "VARCHAR(50)", nullable = true)
	private String firstName;
	
	@Column(name = "last_name", columnDefinition = "VARCHAR(50)", nullable = true)
	private String lastName;
	
	@Column(name = "username", columnDefinition = "VARCHAR(100", nullable = false)
	private String username;
	
	@Column(name = "password", columnDefinition = "VARCHAR(20)", nullable = true)
	private String password;
	
	@Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false)
	@NotEmpty(message = "*Missing email")
	private String email;
	
	@Column(name = "country", columnDefinition = "VARCHAR(60)", nullable = true)
	private String country;
	
	@Column(name = "provider", columnDefinition = "VARCHAR(20)", nullable = true)
	private String provider;
	
	@Column(name = "profile_image", columnDefinition = "VARCHAR(250)", nullable = true)
	private String profile_image;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "users_franchises_set", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "franchise_id"))
	private Set<Franchise> franchises;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "account_type", columnDefinition = "INT", nullable = false)
	private AccountType accountType;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "form_id", nullable = true)
	private ApplicantFormPOJO formData;
	
	//might need to put role for spring authentication
	
	public Users() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Set<Franchise> getFranchises() {
		return franchises;
	}

	public void setFranchises(Set<Franchise> franchises) {
		this.franchises = franchises;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public ApplicantFormPOJO getFormData() {
		return formData;
	}

	public void setFormData(ApplicantFormPOJO formData) {
		this.formData = formData;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
