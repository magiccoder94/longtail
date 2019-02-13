package com.my.longtail.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "offeror_form_data")
public class OfferorForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "offeror_name", columnDefinition = "VARCHAR(50)", nullable = false)
	private String offerorName;
	@Column(name = "company_number", columnDefinition = "VARCHAR(100)", nullable = false)
	private String companyNumber;
	@Column(name = "address", columnDefinition = "VARCHAR(250)", nullable = false)
	private String address;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "incorporation_country_id", nullable = false)
	private Country countryIncorporation;
	@JsonProperty("date_incorporation")
	@Column(name = "date_incorporation", columnDefinition = "DATE", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd-'T'HH:mm:ss")
	private Date dateIncorporation;
	@Column(name = "telephone_number", columnDefinition = "VARCHAR(30)", nullable = false)
	private String telephoneNumber;
	@Column(name = "principal_contact_name", columnDefinition = "VARCHAR(50)", nullable = true)
	private String principalContactPersonName;
	@Column(name = "principal_contact_number", columnDefinition = "VARCHAR(30)", nullable = true)
	private String principalContactPersonNumber;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;
	@AttributeOverrides({
		@AttributeOverride(name = "amount", column = @Column(name = "full_amount_offering_amount", columnDefinition = "DECIMAL(24,4)", nullable = true)),
		@AttributeOverride(name = "currencyCode", column = @Column(name = "full_amount_offering_currency", columnDefinition = "CHAR(3)", nullable = true))
	})
	private Money fullAmountOffering;
	@JsonProperty("date_submitted")
	@Column(name = "date_submitted", columnDefinition = "DATE", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateSubmitted;
	@JsonProperty("date_updated")
	@Column(name = "date_updated", columnDefinition = "DATE", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateUpdated;
	@Column(name = "corporate_document", columnDefinition = "VARCHAR(250)", nullable = false)
	private String corporateDocument;
	@Column(name = "disclosure_document", columnDefinition = "VARCHAR(250)", nullable = false)
	private String disclosureDocument;
	@JsonIgnore
	@OneToMany(mappedBy = "offeror", cascade = CascadeType.MERGE)
	private Set<Franchise> franchise;
	
	public OfferorForm() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOfferorName() {
		return offerorName;
	}

	public void setOfferorName(String offerorName) {
		this.offerorName = offerorName;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Country getCountryIncorporation() {
		return countryIncorporation;
	}

	public void setCountryIncorporation(Country countryIncorporation) {
		this.countryIncorporation = countryIncorporation;
	}

	public Date getDateIncorporation() {
		return dateIncorporation;
	}

	public void setDateIncorporation(Date dateIncorporation) {
		this.dateIncorporation = dateIncorporation;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getPrincipalContactPersonName() {
		return principalContactPersonName;
	}

	public void setPrincipalContactPersonName(String principalContactPersonName) {
		this.principalContactPersonName = principalContactPersonName;
	}

	public String getPrincipalContactPersonNumber() {
		return principalContactPersonNumber;
	}

	public void setPrincipalContactPersonNumber(String principalContactPersonNumber) {
		this.principalContactPersonNumber = principalContactPersonNumber;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Set<Franchise> getFranchise() {
		return franchise;
	}

	public void setFranchise(Set<Franchise> franchise) {
		this.franchise = franchise;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Money getFullAmountOffering() {
		return fullAmountOffering;
	}

	public void setFullAmountOffering(Money fullAmountOffering) {
		this.fullAmountOffering = fullAmountOffering;
	}

	public String getCorporateDocument() {
		return corporateDocument;
	}

	public void setCorporateDocument(String corporateDocument) {
		this.corporateDocument = corporateDocument;
	}

	public String getDisclosureDocument() {
		return disclosureDocument;
	}

	public void setDisclosureDocument(String disclosureDocument) {
		this.disclosureDocument = disclosureDocument;
	}
	
	
}
