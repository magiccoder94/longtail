package com.my.longtail.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MaritalStatus {
	SINGLE(0),
	MARRIED(1),
	DIVORCED(2),
	WIDOWED(3);
	
	private final int value;
	
	private MaritalStatus(int value) {
		this.value = value;
	}
	
	@JsonCreator
	public static MaritalStatus fromValue(int value) {
		switch(value) {
		case 0:
			return SINGLE;
		case 1:
			return MARRIED;
		case 2:
			return DIVORCED;
		case 3:
			return WIDOWED;
		default:
			return null;
		}
	}
	
	@JsonValue
	public int getValue() {
		return this.value;
	}
}
