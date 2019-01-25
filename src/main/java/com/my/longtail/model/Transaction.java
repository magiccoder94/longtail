package com.my.longtail.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "transaction_status", columnDefinition = "INT", nullable = true)
	private TransactionStatus transactionStatus;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "transaction_type", columnDefinition = "INT", nullable = true)
	private TransactionType transactionType;
	
	@Column(name = "trans_date", columnDefinition = "DATETIME", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date transactionDate;
	
	@Column(name = "message", columnDefinition = "VARCHAR(50)", nullable = true)
	private String message;
	
	@AttributeOverrides({
		@AttributeOverride(name = "amount", column = @Column(name = "transaction_amount", columnDefinition = "NUMERIC(24,4)", nullable = true)),
		@AttributeOverride(name = "currencyCode", column = @Column(name = "transaction_amount_currency", columnDefinition = "CHAR(3)", nullable = true))
	})
	private Money transactionAmount;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "applicant_id", nullable = true)
	private ApplicantFormPOJO applicantForm;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id", nullable = true)
	private Users user;
	
	public Transaction() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Money getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Money transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public ApplicantFormPOJO getApplicantForm() {
		return applicantForm;
	}

	public void setApplicantForm(ApplicantFormPOJO applicantForm) {
		this.applicantForm = applicantForm;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
