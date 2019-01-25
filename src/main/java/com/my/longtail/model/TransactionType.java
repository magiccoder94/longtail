package com.my.longtail.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType {
	
	DEPOSIT(0),
	REFUND(1);
	
	private final int value;
	
	private TransactionType(int value) {
		this.value = value;
	}
	
	@JsonCreator
	public static TransactionType fromValue(int value) {
		switch(value) {
			case 0:
				return DEPOSIT;
			case 1:
				return REFUND;
			default:
				return null;
		}
	}
	
	@JsonValue
	public int getValue() {
		return this.value;
	}
	
}
