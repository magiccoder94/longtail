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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name", columnDefinition = "VARCHAR(250)", nullable = false)
	@NotEmpty(message = "*Please provide name for franchise.")
	private String name;
	
	@Column(name = "company_name", columnDefinition = "VARCHAR(250)", nullable = false)
	@NotEmpty(message = "*Please provide name for company.")
	private String companyName;
	
	@Column(name = "criteria_franchisee", columnDefinition = "VARCHAR(250)", nullable = true)
	private String franchiseeCriteria;
	
	@Column(name = "introduction_franchise", columnDefinition = "VARCHAR(250)", nullable = true)
	private String introduction;
	
	@Column(name = "description_package", columnDefinition = "VARCHAR(250)", nullable = true)
	private String descriptionPackage;
	
	@Column(name = "short_description", columnDefinition = "VARCHAR(100)", nullable = true)
	private String shortDescription;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "franchise_type", columnDefinition = "INT", nullable = false)
	private FranchiseType franchiseType;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
//	@JsonIgnore()
//	@ManyToMany(mappedBy = "franchises", cascade = CascadeType.MERGE)
//	private Set<Users> users;
	@OneToMany(mappedBy = "franchise")
	private Set<Users_Franchises> userFranchise;
	
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
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "franchise_status", columnDefinition = "INT", nullable = false)
	private FranchiseStatus franchiseStatus;
	
	@Column(name = "management_participant_needed", columnDefinition = "INT", nullable = false)
	private int managementParticipantNeeded;
	
	@Column(name = "invest_participant_needed", columnDefinition = "INT", nullable = false)
	private int investParticipantNeeded;
	
//	@Column(name = "join_venture_term", columnDefinition = "")
//	private String joinVentureTerm;
	@AttributeOverrides({
		@AttributeOverride(name = "amount", column = @Column(name = "management_service_amount", columnDefinition = "DECIMAL(24,4)", nullable = true)),
		@AttributeOverride(name = "currencyCode", column = @Column(name = "management_service_currency", columnDefinition = "CHAR(3)", nullable = true))
	})
	private Money managementServiceFee;
	
	@AttributeOverrides({
		@AttributeOverride(name = "amount", column = @Column(name = "min_investment_amount", columnDefinition = "DECIMAL(24,4)", nullable = true)),
		@AttributeOverride(name = "currencyCode", column = @Column(name = "minimum_investment_currency", columnDefinition = "CHAR(3)", nullable = true))
	})
	private Money minimumInvestment;
	
	@AttributeOverrides({
		@AttributeOverride(name = "amount", column = @Column(name = "max_investnment_amount", columnDefinition = "DECIMAL(24,4)", nullable = true)),
		@AttributeOverride(name = "currencyCode", column = @Column(name = "max_investnment_currency", columnDefinition = "CHAR(3)", nullable = true))
	})
	private Money maximumInvestment;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "offeror_id", nullable = true)
	private OfferorForm offeror;
	
	public Franchise() {}
	
	public Franchise merge(Franchise existing) {
		existing.setName(this.getName());
		existing.setDescriptionPackage(this.getDescriptionPackage());
		existing.setFranchiseeCriteria(this.getFranchiseeCriteria());
		existing.setIntroduction(this.getIntroduction());
		existing.setCategory(this.getCategory());
		existing.setCompanyName(this.getCompanyName());
		existing.setFranchiseType(this.getFranchiseType());
		existing.setDateUpdated(new Date());
		if(!this.getFranchiseLogoImg().isEmpty())
			existing.setFranchiseLogoImg(this.getFranchiseLogoImg());
		existing.setManagementServiceFee(this.getManagementServiceFee());
		existing.setMinimumInvestment(this.getMinimumInvestment());
		existing.setMaximumInvestment(this.getMaximumInvestment());
		
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

//	public Set<Users> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<Users> users) {
//		this.users = users;
//	}

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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFranchiseeCriteria() {
		return franchiseeCriteria;
	}

	public void setFranchiseeCriteria(String franchiseeCriteria) {
		this.franchiseeCriteria = franchiseeCriteria;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDescriptionPackage() {
		return descriptionPackage;
	}

	public void setDescriptionPackage(String descriptionPackage) {
		this.descriptionPackage = descriptionPackage;
	}

	public FranchiseStatus getFranchiseStatus() {
		return franchiseStatus;
	}

	public void setFranchiseStatus(FranchiseStatus franchiseStatus) {
		this.franchiseStatus = franchiseStatus;
	}

	public int getManagementParticipantNeeded() {
		return managementParticipantNeeded;
	}

	public void setManagementParticipantNeeded(int managementParticipantNeeded) {
		this.managementParticipantNeeded = managementParticipantNeeded;
	}

	public int getInvestParticipantNeeded() {
		return investParticipantNeeded;
	}

	public void setInvestParticipantNeeded(int investParticipantNeeded) {
		this.investParticipantNeeded = investParticipantNeeded;
	}

	public Set<Users_Franchises> getUserFranchise() {
		return userFranchise;
	}

	public void setUserFranchise(Set<Users_Franchises> userFranchise) {
		this.userFranchise = userFranchise;
	}

	public Money getManagementServiceFee() {
		return managementServiceFee;
	}

	public void setManagementServiceFee(Money managementServiceFee) {
		this.managementServiceFee = managementServiceFee;
	}

	public Money getMinimumInvestment() {
		return minimumInvestment;
	}

	public void setMinimumInvestment(Money minimumInvestment) {
		this.minimumInvestment = minimumInvestment;
	}

	public Money getMaximumInvestment() {
		return maximumInvestment;
	}

	public void setMaximumInvestment(Money maximumInvestment) {
		this.maximumInvestment = maximumInvestment;
	}
	
}
