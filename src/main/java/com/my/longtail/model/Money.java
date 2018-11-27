package com.my.longtail.model;

import java.math.BigDecimal;
import java.util.Currency;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class Money {
	
	@JsonProperty("amount")
	private BigDecimal amount;
	
	@JsonProperty("currency_code")
	private String currencyCode;
	
	
	public Money() {}
	
	public Money(BigDecimal amount, Currency currencyCode) {
		this.amount = amount;
		this.currencyCode = currencyCode.getCurrencyCode();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
}
