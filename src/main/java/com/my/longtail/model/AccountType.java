package com.my.longtail.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountType {
	ADMINISTRATOR(0),
	INVESTOR(1);
	
	private final int value;
	
	private AccountType(int value) {
		this.value = value;
	}
	
	@JsonCreator
	public static AccountType fromValue(int value) {
		switch(value) {
		case 0:
			return ADMINISTRATOR;
		case 1:
			return INVESTOR;
		default:
			return null;
		}
	}
	
	@JsonValue
	public int getValue() {
		return this.value;
	}
}
