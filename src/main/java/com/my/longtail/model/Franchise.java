package com.my.longtail.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "franchises")
public class Franchise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name", columnDefinition = "VARCHAR(250)", nullable = false)
	@NotEmpty(message = "*Please provide name for franchise.")
	private String name;
	
	@Column(name = "company_name", columnDefinition = "VARCHAR(250)", nullable = false)
	@NotEmpty(message = "*Please provide name for company.")
	private String companyName;
	
	@Column(name = "description", columnDefinition = "VARCHAR(250)", nullable = true)
	private String description;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "franchise_type", columnDefinition = "INT", nullable = false)
	private FranchiseType franchiseType;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@JsonIgnore()
	@ManyToMany(mappedBy = "franchises", cascade = CascadeType.MERGE)
	private Set<Users> users;
	
	@JsonProperty("createdDate")
	@Column(name = "created_date", columnDefinition = "DATE", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateCreated;
	
	@JsonProperty("updatedDate")
	@Column(name = "updated_date", columnDefinition = "DATE", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateUpdated;
	
	@Column(name = "franchise_logo", columnDefinition = "VARCHAR(250)", nullable = true)
	private String franchiseLogoImg;
	
	@Column(name = "investor_interested", columnDefinition = "INT", nullable = false)
	private int investorInterested = 0;
	
	public Franchise() {}
	
	public Franchise merge(Franchise existing) {
		existing.setName(this.getName());
		existing.setDescription(this.getDescription());
		existing.setCategory(this.getCategory());
		existing.setCompanyName(this.getCompanyName());
		existing.setFranchiseType(this.getFranchiseType());
		existing.setDateUpdated(new Date());
		existing.setInvestorInterested(this.getInvestorInterested());
		if(!this.getFranchiseLogoImg().isEmpty())
			existing.setFranchiseLogoImg(this.getFranchiseLogoImg());
		
		return existing;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public FranchiseType getFranchiseType() {
		return franchiseType;
	}

	public void setFranchiseType(FranchiseType franchiseType) {
		this.franchiseType = franchiseType;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getFranchiseLogoImg() {
		return franchiseLogoImg;
	}

	public void setFranchiseLogoImg(String franchiseLogoImg) {
		this.franchiseLogoImg = franchiseLogoImg;
	}

	public int getInvestorInterested() {
		return investorInterested;
	}

	public void setInvestorInterested(int investorInterested) {
		this.investorInterested = investorInterested;
	}
	
}