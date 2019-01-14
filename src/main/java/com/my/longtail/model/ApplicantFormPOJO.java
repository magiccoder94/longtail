package com.my.longtail.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "participant_form_data")
public class ApplicantFormPOJO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "participant_name", columnDefinition = "VARCHAR(50)", nullable = false)
	private String participantName;
	@Column(name = "passport_number", columnDefinition = "VARCHAR(50)", nullable = false)
	private String passportNumber;
	@Column(name = "address", columnDefinition = "VARCHAR(250)", nullable = true)
	private String address;
	@Column(name = "nationality", columnDefinition = "VARCHAR(30)", nullable = false)
	private String nationality;
	@Column(name = "gender", columnDefinition = "VARCHAR(15)", nullable = false)
	private String gender;
	@Column(name = "telephone_number", columnDefinition = "VARCHAR(25)", nullable = false)
	private String telephoneNumber;
	@Column(name = "bank_details", columnDefinition = "VARCHAR(50)", nullable = false)
	private String bankDetails;
	@Column(name = "img_profile", columnDefinition = "VARCHAR(250)", nullable = false)
	private String imgProfilePhoto;
	@Column(name = "img_passport", columnDefinition = "VARCHAR(250)", nullable = false)
	private String imgPassport;
	@Column(name = "img_proof_address", columnDefinition = "VARCHAR(250)", nullable = false)
	private String imgProofAddress;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "form_category_sets", joinColumns = @JoinColumn(name = "form_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categoriesParticpate;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "country_id", nullable = false)
	private Country countryChoice;
	@JsonProperty("investment_range")
	@AttributeOverrides({
		@AttributeOverride(name = "amount", column = @Column(name = "invest_range_amount", columnDefinition = "NUMERIC(24,4)", nullable = true)),
		@AttributeOverride(name = "currencyCode", column = @Column(name = "invest_range_currency", columnDefinition = "CHAR(3)", nullable = true))
	})
	private Money investmentRange;
	@Column(name = "percentage_share_target", columnDefinition = "NUMERIC(24,4)", nullable = true)
	private BigDecimal percentageShareTarget;
	@Column(name = "management_participation", columnDefinition = "BIT", nullable = true)
	private boolean managementParticipation;
	@Column(name = "seek_out_period", columnDefinition = "INT", nullable = true)
	private int seekOutPeriod;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "transaction_id", nullable = true)
	private Transaction transaction;
	@JsonProperty("date_submitted")
	@Column(name = "date_submitted", columnDefinition = "DATE", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateSubmitted;
	@JsonProperty("date_updated")
	@Column(name = "date_updated", columnDefinition = "DATE", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateUpdated;
	
	public ApplicantFormPOJO() {}
	
	public void merge(ApplicantFormPOJO existing) {
		existing.setParticipantName(this.getParticipantName());
		existing.setPassportNumber(this.getPassportNumber());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	public String getImgProfilePhoto() {
		return imgProfilePhoto;
	}

	public void setImgProfilePhoto(String imgProfilePhoto) {
		this.imgProfilePhoto = imgProfilePhoto;
	}

	public String getImgPassport() {
		return imgPassport;
	}

	public void setImgPassport(String imgPassport) {
		this.imgPassport = imgPassport;
	}

	public String getImgProofAddress() {
		return imgProofAddress;
	}

	public void setImgProofAddress(String imgProofAddress) {
		this.imgProofAddress = imgProofAddress;
	}

	public Set<Category> getCategoriesParticpate() {
		return categoriesParticpate;
	}

	public void setCategoriesParticpate(Set<Category> categoriesParticpate) {
		this.categoriesParticpate = categoriesParticpate;
	}

	public Country getCountryChoice() {
		return countryChoice;
	}

	public void setCountryChoice(Country countryChoice) {
		this.countryChoice = countryChoice;
	}

	public Money getInvestmentRange() {
		return investmentRange;
	}

	public void setInvestmentRange(Money investmentRange) {
		this.investmentRange = investmentRange;
	}

	public BigDecimal getPercentageShareTarget() {
		return percentageShareTarget;
	}

	public void setPercentageShareTarget(BigDecimal percentageShareTarget) {
		this.percentageShareTarget = percentageShareTarget;
	}

	public boolean isManagementParticipation() {
		return managementParticipation;
	}

	public void setManagementParticipation(boolean managementParticipation) {
		this.managementParticipation = managementParticipation;
	}

	public int getSeekOutPeriod() {
		return seekOutPeriod;
	}

	public void setSeekOutPeriod(int seekOutPeriod) {
		this.seekOutPeriod = seekOutPeriod;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
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
	
}
