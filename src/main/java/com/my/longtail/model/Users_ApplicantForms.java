package com.my.longtail.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_APPLICANT_FORMS")
public class Users_ApplicantForms implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Users user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ApplicantFormPOJO applicantForm;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "applicant_status", columnDefinition = "INT", nullable = true)
	private ApplicantStatus applicantStatus;

	public Users getUser() {
		return user;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setUser(Users user) {
		this.user = user;
	}

	public ApplicantFormPOJO getApplicantForm() {
		return applicantForm;
	}

	public void setApplicantForm(ApplicantFormPOJO applicantForm) {
		this.applicantForm = applicantForm;
	}

	public ApplicantStatus getApplicantStatus() {
		return applicantStatus;
	}

	public void setApplicantStatus(ApplicantStatus applicantStatus) {
		this.applicantStatus = applicantStatus;
	}
	

}
