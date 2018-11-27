package com.my.longtail.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "applicant_form_data")
public class ApplicantFormPOJO {
	//PART A.	INDIVIDUAL APPLICANT 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "name", columnDefinition = "VARCHAR(20)", nullable = true)
	private String name;
	@Column(name = "year_birth", columnDefinition = "VARCHAR(10)", nullable = true)
	private String yearBirth;
	@Column(name = "nationality", columnDefinition = "VARCHAR(20)", nullable = true)
	private String nationality;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "marital_status", columnDefinition = "INT", nullable = false)
	private MaritalStatus maritalStatus;
	@Column(name = "home_ph", columnDefinition = "VARCHAR(20)", nullable = true)
	private String homePhoneNo;
	@Column(name = "mobile_ph", columnDefinition = "VARCHAR(20)", nullable = true)
	private String mobilePhoneNo;
	@Column(name = "email", columnDefinition = "VARCHAR(50)", nullable = true)
	private String email;
	@Column(name = "fax", columnDefinition = "VARCHAR(50)", nullable = true)
	private String fax;
	@Column(name = "resident_c_address", columnDefinition = "VARCHAR(100)", nullable = true)
	private String residentCountryAddress;
	@Column(name = "academic_qualification", columnDefinition = "VARCHAR(50)", nullable = true)
	private String academicQualification;
	@Column(name = "occupation_business", columnDefinition = "VARCHAR(50)", nullable = true)
	private String occupationBusiness;
	@Column(name = "employer_business_name", columnDefinition = "VARCHAR(50)", nullable = true)
	private String employerBusinessName;
	//PART B CORPORATE APPLICANT 
	@Column(name = "company_business_name", columnDefinition = "VARCHAR(50)", nullable = true)
	private String companyBusinessName;
	@Column(name = "incorporation_registration", columnDefinition = "VARCHAR(50)", nullable = true)
	private String incorporationRegistration;
	@Column(name = "corp_ph", columnDefinition = "VARCHAR(20)", nullable = true)
	private String corpPhoneNo;
	@Column(name = "corp_fax", columnDefinition = "VARCHAR(20)", nullable = true)
	private String corpFax;
	@Column(name = "corp_email", columnDefinition = "VARCHAR(50)", nullable = true)
	private String corpEmail;
	@Column(name = "year_incorporated", columnDefinition = "INT", nullable = true)
	private int yearIncorporated;
	@Column(name = "incorporation_number", columnDefinition = "VARCHAR(30)", nullable = true)
	private String incorporationNumber;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "entity_type", columnDefinition = "INT", nullable = false)
	private EntityType entityType;
	@Column(name = "other_entity", columnDefinition = "VARCHAR(20)", nullable = true)
	private String otherEntity;
	@JsonProperty("capitalisation")
	@AttributeOverrides({
		@AttributeOverride(name = "amount", column = @Column(name = "capital_amount", columnDefinition = "NUMERIC(24,4)", nullable = true)),
		@AttributeOverride(name = "currency", column = @Column(name = "capital_currency", columnDefinition = "CHAR(3)", nullable = true))
	})
	private Money capitalisation;
	@JsonProperty("pre_year_sales_turnover")
	@AttributeOverrides({
		@AttributeOverride(name = "amount", column = @Column(name = "pre_year_sales_turnover_amount", columnDefinition = "NUMERIC(24,4)", nullable = true)),
		@AttributeOverride(name = "currency", column = @Column(name = "pre_year_sales_turnover_currency", columnDefinition = "CHAR(3)", nullable = true))
	})
	private Money preYearSalesTurnOver;
	@Column(name = "pre_year_sales_turnover_param1", columnDefinition = "VARCHAR(10)", nullable = true)
	private String preYearSalesTurnOverParam1;
	@Column(name = "pre_year_sales_turnover_param2", columnDefinition = "VARCHAR(10)", nullable = true)
	private String preYearSalesTurnOverParam2;
	@Column(name = "percentage_share", columnDefinition = "VARCHAR(100)", nullable = true)
	private String percentageShare;
	@Column(name = "managin_principal", columnDefinition = "VARCHAR(50)", nullable = true)
	private String managingPrincipal;
	@Column(name = "m_principal_age", columnDefinition = "INT", nullable = true)
	private int mPrincipalAge;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "m_principal_marital_status", columnDefinition = "INT", nullable = true)
	private MaritalStatus mPrincipalMaritalStatus;
	@Column(name = "m_principal_nationality", columnDefinition = "VARCHAR(20)", nullable = true)
	private String mPrincipalNationality;
	@Column(name = "m_principal_occupation_designation", columnDefinition = "VARCHAR(20)", nullable = true)
	private String mPrincipalOccupationDesignation;
	//PART C OTHER INFORMATION
	@JsonProperty("fund_available_invest")
	@AttributeOverrides({
		@AttributeOverride(name = "amount", column = @Column(name = "fund_available_invest_amount", columnDefinition = "NUMERIC(24,4)", nullable = true)),
		@AttributeOverride(name = "currency", column = @Column(name = "fund_available_invest_currency", columnDefinition = "CHAR(3)", nullable = true))
	})
	private Money fundAvailableInvest;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "source_fund_type", columnDefinition = "INT", nullable = true)
	private SourceFundType sourceFunds;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "interested_franchise_type", columnDefinition = "INT", nullable = true)
	private FranchiseType interestedFranchise;
	@Column(name = "country_territory", columnDefinition = "VARCHAR(100)", nullable = true)
	private String countryTerritory;
	@Column(name = "franchise_familiarity", columnDefinition = "INT", nullable = true)
	private int franchiseFamiliarity;
	@Column(name = "operated_franchise", nullable = false)
	private boolean operatedFranchise;
	@Column(name = "franchise_name", columnDefinition = "VARCHAR(20)", nullable = true)
	private String franchiseName;
	@Column(name = "country_origin", columnDefinition = "VARCHAR(20)", nullable = true)
	private String countryOrigin;
	@Column(name = "business_nature", columnDefinition = "VARCHAR(20)", nullable = true)
	private String businessNature;
	@Column(name = "franchise_period", columnDefinition = "VARCHAR(20)", nullable = true)
	private String franchisePeriod;
	@Column(name = "operation_education_training", columnDefinition = "INT", nullable = true)
	private int operationEducationTraining;
	@Column(name = "operated_kindergarden", nullable = false)
	private boolean operateKindergarden;
	@Column(name = "business_description", columnDefinition = "VARCHAR(100)", nullable = true)
	private String businessDescription;
	@Column(name = "business_location", columnDefinition = "VARCHAR(30)", nullable = true)
	private String businessLocation;
	@Column(name = "business_period", columnDefinition = "INT", nullable = true)
	private int businessPeriod;
	@Column(name = "premise_owned", nullable = false)
	private boolean premiseOwn;
	@Column(name = "premise_location", columnDefinition = "VARCHAR(50)", nullable = true)
	private String premiseLocation;
	@JsonProperty("monthly_rent")
	@AttributeOverrides({
		@AttributeOverride(name = "amount", column = @Column(name = "monthly_rent_amount", columnDefinition = "NUMERIC(24,4)", nullable = true)),
		@AttributeOverride(name = "currency", column = @Column(name = "monthly_rent_currency", columnDefinition = "CHAR(3)", nullable = true))
	})
	private Money monthlyRent;
	@Column(name = "franchise_reason", columnDefinition = "VARCHAR(100)", nullable = true)
	private String franchiseReason;
	@Column(name = "applicant_strength", columnDefinition = "VARCHAR(250)", nullable = true)
	private String applicantStrength;
	@Column(name = "relevant_info", columnDefinition = "VARCHAR(250)", nullable = true)
	private String relevantInfo;
	@JsonProperty("createdDate")
	@Column(name = "created_date", columnDefinition = "DATE", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdDate;
	@JsonProperty("updatedDate")
	@Column(name = "updated_date", columnDefinition = "DATE", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date updatedDate;

	public ApplicantFormPOJO() {}
	
	public ApplicantFormPOJO merge(ApplicantFormPOJO existing) {
		existing.setAcademicQualification(this.getAcademicQualification());
		existing.setApplicantStrength(this.getApplicantStrength());
		existing.setBusinessDescription(this.getBusinessDescription());
		existing.setBusinessLocation(this.getBusinessLocation());
		existing.setBusinessNature(this.getBusinessNature());
		existing.setBusinessPeriod(this.getBusinessPeriod());
		existing.setCapitalisation(this.getCapitalisation());
		existing.setCompanyBusinessName(this.getCompanyBusinessName());
		existing.setCorpEmail(this.getCorpEmail());
		existing.setCorpFax(this.getCorpFax());
		existing.setCorpPhoneNo(this.getCorpPhoneNo());
		existing.setCountryOrigin(this.getCountryOrigin());
		existing.setCountryTerritory(this.getCountryTerritory());
		existing.setEmail(this.getEmail());
		existing.setEmployerBusinessName(this.getEmployerBusinessName());
		existing.setEntityType(this.getEntityType());
		existing.setFax(this.getFax());
		existing.setFranchiseFamiliarity(this.getFranchiseFamiliarity());
		existing.setFranchiseName(this.getFranchiseName());
		existing.setFranchisePeriod(this.getFranchisePeriod());
		existing.setFranchiseReason(this.getFranchiseReason());
		existing.setFundAvailableInvest(this.getFundAvailableInvest());
		existing.setHomePhoneNo(this.getHomePhoneNo());
		existing.setIncorporationNumber(this.getIncorporationNumber());
		existing.setIncorporationRegistration(this.getIncorporationRegistration());
		existing.setInterestedFranchise(this.getInterestedFranchise());
		existing.setManagingPrincipal(this.getManagingPrincipal());
		existing.setMaritalStatus(this.getMaritalStatus());
		existing.setMobilePhoneNo(this.getMobilePhoneNo());
		existing.setMonthlyRent(this.getMonthlyRent());
		existing.setmPrincipalAge(this.getmPrincipalAge());
		existing.setmPrincipalMaritalStatus(this.getmPrincipalMaritalStatus());
		existing.setmPrincipalNationality(this.getmPrincipalNationality());
		existing.setmPrincipalOccupationDesignation(this.getmPrincipalOccupationDesignation());
		existing.setName(this.getName());
		existing.setNationality(this.getNationality());
		existing.setOccupationBusiness(this.getOccupationBusiness());
		existing.setOperatedFranchise(this.isOperatedFranchise());
		existing.setOperateKindergarden(this.isOperateKindergarden());
		existing.setOperationEducationTraining(this.getOperationEducationTraining());
		existing.setOtherEntity(this.getOtherEntity());
		existing.setPercentageShare(this.getPercentageShare());
		existing.setPremiseLocation(this.getPremiseLocation());
		existing.setPremiseOwn(this.isPremiseOwn());
		existing.setPreYearSalesTurnOver(this.getPreYearSalesTurnOver());
		existing.setPreYearSalesTurnOverParam1(this.getPreYearSalesTurnOverParam1());
		existing.setPreYearSalesTurnOverParam2(this.getPreYearSalesTurnOverParam2());
		existing.setRelevantInfo(this.getRelevantInfo());
		existing.setResidentCountryAddress(this.getResidentCountryAddress());
		existing.setSourceFunds(this.getSourceFunds());
		existing.setYearBirth(this.getYearBirth());
		existing.setYearIncorporated(this.getYearIncorporated());
		
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

	public String getYearBirth() {
		return yearBirth;
	}

	public void setYearBirth(String yearBirth) {
		this.yearBirth = yearBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getHomePhoneNo() {
		return homePhoneNo;
	}

	public void setHomePhoneNo(String homePhoneNo) {
		this.homePhoneNo = homePhoneNo;
	}

	public String getMobilePhoneNo() {
		return mobilePhoneNo;
	}

	public void setMobilePhoneNo(String mobilePhoneNo) {
		this.mobilePhoneNo = mobilePhoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getResidentCountryAddress() {
		return residentCountryAddress;
	}

	public void setResidentCountryAddress(String residentCountryAddress) {
		this.residentCountryAddress = residentCountryAddress;
	}

	public String getAcademicQualification() {
		return academicQualification;
	}

	public void setAcademicQualification(String academicQualification) {
		this.academicQualification = academicQualification;
	}

	public String getOccupationBusiness() {
		return occupationBusiness;
	}

	public void setOccupationBusiness(String occupationBusiness) {
		this.occupationBusiness = occupationBusiness;
	}

	public String getEmployerBusinessName() {
		return employerBusinessName;
	}

	public void setEmployerBusinessName(String employerBusinessName) {
		this.employerBusinessName = employerBusinessName;
	}

	public String getCompanyBusinessName() {
		return companyBusinessName;
	}

	public void setCompanyBusinessName(String companyBusinessName) {
		this.companyBusinessName = companyBusinessName;
	}

	public String getIncorporationRegistration() {
		return incorporationRegistration;
	}

	public void setIncorporationRegistration(String incorporationRegistration) {
		this.incorporationRegistration = incorporationRegistration;
	}

	public String getCorpPhoneNo() {
		return corpPhoneNo;
	}

	public void setCorpPhoneNo(String corpPhoneNo) {
		this.corpPhoneNo = corpPhoneNo;
	}

	public String getCorpFax() {
		return corpFax;
	}

	public void setCorpFax(String corpFax) {
		this.corpFax = corpFax;
	}

	public String getCorpEmail() {
		return corpEmail;
	}

	public void setCorpEmail(String corpEmail) {
		this.corpEmail = corpEmail;
	}

	public int getYearIncorporated() {
		return yearIncorporated;
	}

	public void setYearIncorporated(int yearIncorporated) {
		this.yearIncorporated = yearIncorporated;
	}

	public String getIncorporationNumber() {
		return incorporationNumber;
	}

	public void setIncorporationNumber(String incorporationNumber) {
		this.incorporationNumber = incorporationNumber;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public String getOtherEntity() {
		return otherEntity;
	}

	public void setOtherEntity(String otherEntity) {
		this.otherEntity = otherEntity;
	}

	public Money getCapitalisation() {
		return capitalisation;
	}

	public void setCapitalisation(Money capitalisation) {
		this.capitalisation = capitalisation;
	}

	public Money getPreYearSalesTurnOver() {
		return preYearSalesTurnOver;
	}

	public void setPreYearSalesTurnOver(Money preYearSalesTurnOver) {
		this.preYearSalesTurnOver = preYearSalesTurnOver;
	}

	public String getPreYearSalesTurnOverParam1() {
		return preYearSalesTurnOverParam1;
	}

	public void setPreYearSalesTurnOverParam1(String preYearSalesTurnOverParam1) {
		this.preYearSalesTurnOverParam1 = preYearSalesTurnOverParam1;
	}

	public String getPreYearSalesTurnOverParam2() {
		return preYearSalesTurnOverParam2;
	}

	public void setPreYearSalesTurnOverParam2(String preYearSalesTurnOverParam2) {
		this.preYearSalesTurnOverParam2 = preYearSalesTurnOverParam2;
	}

	public String getPercentageShare() {
		return percentageShare;
	}

	public void setPercentageShare(String percentageShare) {
		this.percentageShare = percentageShare;
	}

	public String getManagingPrincipal() {
		return managingPrincipal;
	}

	public void setManagingPrincipal(String managingPrincipal) {
		this.managingPrincipal = managingPrincipal;
	}

	public int getmPrincipalAge() {
		return mPrincipalAge;
	}

	public void setmPrincipalAge(int mPrincipalAge) {
		this.mPrincipalAge = mPrincipalAge;
	}

	public MaritalStatus getmPrincipalMaritalStatus() {
		return mPrincipalMaritalStatus;
	}

	public void setmPrincipalMaritalStatus(MaritalStatus mPrincipalMaritalStatus) {
		this.mPrincipalMaritalStatus = mPrincipalMaritalStatus;
	}

	public String getmPrincipalNationality() {
		return mPrincipalNationality;
	}

	public void setmPrincipalNationality(String mPrincipalNationality) {
		this.mPrincipalNationality = mPrincipalNationality;
	}

	public String getmPrincipalOccupationDesignation() {
		return mPrincipalOccupationDesignation;
	}

	public void setmPrincipalOccupationDesignation(String mPrincipalOccupationDesignation) {
		this.mPrincipalOccupationDesignation = mPrincipalOccupationDesignation;
	}

	public Money getFundAvailableInvest() {
		return fundAvailableInvest;
	}

	public void setFundAvailableInvest(Money fundAvailableInvest) {
		this.fundAvailableInvest = fundAvailableInvest;
	}

	public SourceFundType getSourceFunds() {
		return sourceFunds;
	}

	public void setSourceFunds(SourceFundType sourceFunds) {
		this.sourceFunds = sourceFunds;
	}

	public FranchiseType getInterestedFranchise() {
		return interestedFranchise;
	}

	public void setInterestedFranchise(FranchiseType interestedFranchise) {
		this.interestedFranchise = interestedFranchise;
	}

	public String getCountryTerritory() {
		return countryTerritory;
	}

	public void setCountryTerritory(String countryTerritory) {
		this.countryTerritory = countryTerritory;
	}

	public int getFranchiseFamiliarity() {
		return franchiseFamiliarity;
	}

	public void setFranchiseFamiliarity(int franchiseFamiliarity) {
		this.franchiseFamiliarity = franchiseFamiliarity;
	}

	public boolean isOperatedFranchise() {
		return operatedFranchise;
	}

	public void setOperatedFranchise(boolean operatedFranchise) {
		this.operatedFranchise = operatedFranchise;
	}

	public String getFranchiseName() {
		return franchiseName;
	}

	public void setFranchiseName(String franchiseName) {
		this.franchiseName = franchiseName;
	}

	public String getCountryOrigin() {
		return countryOrigin;
	}

	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}

	public String getBusinessNature() {
		return businessNature;
	}

	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}

	public String getFranchisePeriod() {
		return franchisePeriod;
	}

	public void setFranchisePeriod(String franchisePeriod) {
		this.franchisePeriod = franchisePeriod;
	}

	public int getOperationEducationTraining() {
		return operationEducationTraining;
	}

	public void setOperationEducationTraining(int operationEducationTraining) {
		this.operationEducationTraining = operationEducationTraining;
	}

	public boolean isOperateKindergarden() {
		return operateKindergarden;
	}

	public void setOperateKindergarden(boolean operateKindergarden) {
		this.operateKindergarden = operateKindergarden;
	}

	public String getBusinessDescription() {
		return businessDescription;
	}

	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}

	public String getBusinessLocation() {
		return businessLocation;
	}

	public void setBusinessLocation(String businessLocation) {
		this.businessLocation = businessLocation;
	}

	public int getBusinessPeriod() {
		return businessPeriod;
	}

	public void setBusinessPeriod(int businessPeriod) {
		this.businessPeriod = businessPeriod;
	}

	public boolean isPremiseOwn() {
		return premiseOwn;
	}

	public void setPremiseOwn(boolean premiseOwn) {
		this.premiseOwn = premiseOwn;
	}

	public String getPremiseLocation() {
		return premiseLocation;
	}

	public void setPremiseLocation(String premiseLocation) {
		this.premiseLocation = premiseLocation;
	}

	public Money getMonthlyRent() {
		return monthlyRent;
	}

	public void setMonthlyRent(Money monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	public String getFranchiseReason() {
		return franchiseReason;
	}

	public void setFranchiseReason(String franchiseReason) {
		this.franchiseReason = franchiseReason;
	}

	public String getApplicantStrength() {
		return applicantStrength;
	}

	public void setApplicantStrength(String applicantStrength) {
		this.applicantStrength = applicantStrength;
	}

	public String getRelevantInfo() {
		return relevantInfo;
	}

	public void setRelevantInfo(String relevantInfo) {
		this.relevantInfo = relevantInfo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}
