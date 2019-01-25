package com.my.longtail.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionStatus {
	
	SUCCESS(0),
	FAIL(1),
	PENDING(2);
	
	private final int value;
	
	private TransactionStatus(int value) {
		this.value = value;
	}
	
	@JsonCreator
	public static TransactionStatus fromValue(int value) {
		switch(value) {
			case 0:
				return SUCCESS;
			case 1:
				return FAIL;
			case 2:
				return PENDING;
			default:
				return null;
		}
	}
	
	@JsonValue
	public int getValue() {
		return this.value;
	}
	
}
