package com.my.longtail.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FranchiseType {
	SINGLE(0),
	MULTIPLE(1),
	COUNTRY_MASTER(2),
	AREA_MASTER(3);
	
	private final int value;
	
	private FranchiseType(int value) {
		this.value = value;
	}
	
	@JsonCreator
	public static FranchiseType fromValue(int value) {
		switch(value) {
		case 0:
			return SINGLE;
		case 1:
			return MULTIPLE;
		case 2:
			return COUNTRY_MASTER;
		case 3:
			return AREA_MASTER;
		default:
			return null;
		}
	}
	
	@JsonValue
	public int getValue() {
		return this.value;
	}
}
