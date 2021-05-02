/**
 * 
 */
package com.mazhar.reactive.model;

/**
 * @author mazhar
 *
 */
public enum Gender {

	MALE("male"), FEMALE("female"), COMMON("Common Gender");

	private String value;

	Gender(String value) {
		this.value = value;
	}

	public static Gender getType(String name) {
		if (name.isEmpty())
			return MALE;
		for (Gender g : Gender.values()) {
			if (g.getValue().equals(name))
				return g;
		}
		return MALE;

	}

	public String getValue() {
		return value;
	}
}
