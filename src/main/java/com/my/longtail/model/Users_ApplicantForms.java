package com.my.longtail.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Users_ApplicantForms implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Users user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ApplicantFormPOJO applicantForm;
	
	@Column(name = "applicant_status", columnDefinition = "INT", nullable = true)
	private int applicantStatus;

	public Users getUser() {
		return user;
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

	public int getApplicantStatus() {
		return applicantStatus;
	}

	public void setApplicantStatus(int applicantStatus) {
		this.applicantStatus = applicantStatus;
	}
	

}
