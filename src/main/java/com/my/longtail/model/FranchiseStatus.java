package com.my.longtail.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FranchiseStatus {
	PARTICIPANT_NEEDED(0),
	MAXIMUM_PARITICPANT_ACHIVE(1),
	DISABLED(2);
	
	private final int value;
	
	private FranchiseStatus(int value) {
		this.value = value;
	}
	
	@JsonCreator
	public static FranchiseStatus fromValue(int value) {
		switch(value) {
			case 0:
				return PARTICIPANT_NEEDED;
			case 1:
				return MAXIMUM_PARITICPANT_ACHIVE;
			default:
				return null;
		}
	}
	
	@JsonValue
	public int getValue() {
		return this.value;
	}
}
