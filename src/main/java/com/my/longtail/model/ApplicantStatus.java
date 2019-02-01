package com.my.longtail.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ApplicantStatus {
	
	FULFILLED(0),
	PENDING_PAYMENT(1),
	PENDING_ASSIGN(2);
	
	private final int value;
	
	private ApplicantStatus(int value) {
		this.value = value;
	}
	
	@JsonCreator
	public static ApplicantStatus fromValue(int value) {
		switch(value) {
			case 0:
				return FULFILLED;
			case 1:
				return PENDING_PAYMENT;
			case 2:
				return PENDING_ASSIGN;
			default:
				return null;
		}
	}
	
	@JsonValue
	public int getValue() {
		return this.value;
	}
	
}
