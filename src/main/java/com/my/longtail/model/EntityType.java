package com.my.longtail.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EntityType {
	
	PRIVATE_LIMITED(0),
	PUBLIC(1),
	PARTNERSHIP(2),
	SOLE_PROPRIETORSHIP(3),
	OTHERS(4);
	
	private final int value;
	
	private EntityType(int value) {
		this.value = value;
	}
	
	@JsonCreator
	public static EntityType fromValue(int value) {
		switch(value) {
		case 0:
			return PRIVATE_LIMITED;
		case 1:
			return PUBLIC;
		case 2:
			return PARTNERSHIP;
		case 3:
			return SOLE_PROPRIETORSHIP;
		case 4:
			return OTHERS;
		default:
			return null;
		}
	}
	
	@JsonValue
	public int getValue() {
		return this.value;
	}
}
