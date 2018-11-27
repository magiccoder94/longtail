package com.my.longtail.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EntityType {
	
	SOLE_PROPRIETORSHIP(0),
	GENERAL_PARTNERSHIP(1),
	LIMITED_PARTNERSHIP(2),
	LIMITED_LIABILITY_COMPANY(3),
	C_CORPORATION(4),
	S_CORPORATION(5);
	
	private final int value;
	
	private EntityType(int value) {
		this.value = value;
	}
	
	@JsonCreator
	public static EntityType fromValue(int value) {
		switch(value) {
		case 1:
			return SOLE_PROPRIETORSHIP;
		case 2:
			return GENERAL_PARTNERSHIP;
		case 3:
			return LIMITED_PARTNERSHIP;
		case 4:
			return LIMITED_LIABILITY_COMPANY;
		case 5:
			return C_CORPORATION;
		case 6:
			return S_CORPORATION;
		default:
			return null;
		}
	}
	
	@JsonValue
	public int getValue() {
		return this.value;
	}
}
