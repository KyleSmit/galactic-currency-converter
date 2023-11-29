package com.kyle.galacticcurrencyconverter.core.query;

public enum QueryType {

	HOW_MUCH("HOW MUCH IS"),
	HOW_MANY("HOW MANY CREDIT"),
	INVALID_QUERY("I have no idea what you are talking about");

	public final String value;

	QueryType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static boolean hasQueryValue(String value){
		for (QueryType type: QueryType.values()) {
			if (value.contains(type.value)) {
				return true;
			}
		}
		return false;
	}

	public static QueryType getType(String value) {
		for (QueryType type: QueryType.values()) {
			if (value.contains(type.value)) {
				return type;
			}
		}
		return INVALID_QUERY;
	}

}
