package com.my.longtail.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SourceFundType {
	INTERNAL(0),
	EXTERNAL(1);
	
private final int value;
	
	private SourceFundType(int value) {
		this.value = value;
	}
	
	@JsonCreator
	public static SourceFundType fromValue(int value) {
		switch (value) {
		case 0:
			return INTERNAL;
		case 1:
			return EXTERNAL;
		default:
			return null;
		}
	}
	
	@JsonValue
	public int getValue() {
        return this.value;
    }
}
