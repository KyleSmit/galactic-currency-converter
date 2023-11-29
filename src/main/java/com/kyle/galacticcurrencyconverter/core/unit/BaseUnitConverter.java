package com.kyle.galacticcurrencyconverter.core.unit;

import org.springframework.stereotype.Component;

@Component
public class BaseUnitConverter {
//	private final UnitManager unitManager;
//
//	public BaseUnitConverter(UnitManager unitManager) {
//		this.unitManager = unitManager;
//	}

	/**
	 * Validates BaseUnit and calculates its total value
	 */
	public static int convertBaseUnit(String baseUnitInput) {
		BaseUnit previousDigit = null;
		int characterRepeatCount = 1;
		int total = 0;

		for(int i = 0; i < baseUnitInput.length(); i++){
			BaseUnit currentDigit = BaseUnit.valueOf(String.valueOf(baseUnitInput.charAt(i)));
			int currentRomanCharNumericValue = currentDigit.getValue();

			if (currentDigit.equals(previousDigit)) {
				characterRepeatCount++;

				if (characterRepeatCount > 3) {
					throw new IllegalArgumentException("(" + currentDigit + ")Repeated too often");
				}
				if (currentDigit.isRepeatable()) {
					total += currentRomanCharNumericValue;
				} else {
					throw new IllegalArgumentException("(" + currentDigit + ") Cannot be repeated");
				}
			} else if (previousDigit != null && previousDigit.compareTo(currentDigit) < 0) {
				if (characterRepeatCount > 1) {
					throw new IllegalArgumentException("(" + currentDigit + ")Repeated to many times before larger digit");
				}
				if (previousDigit.subtractableFrom(currentDigit)) {
					characterRepeatCount = 1;
					total += currentRomanCharNumericValue - (2 * previousDigit.getValue());
				} else {
					throw new IllegalArgumentException("(" + previousDigit + ") may not be subtracted from" + "(" + currentDigit + ")");
				}
			} else {
				characterRepeatCount = 1;
				total += currentRomanCharNumericValue;
			}

			previousDigit = currentDigit;
		}
		return total;
	}

	/**
	 * Unit Manager Implementation
	 */
	//	public int convertBaseUnit(String baseUnitInput) {
//		BaseUnit previousDigit = null;
//		int characterRepeatCount = 1;
//		int total = 0;
//
//		for(int i = 0; i < baseUnitInput.length(); i++){
//			Unit currentDigit = unitManager.getUnits().get(baseUnitInput.charAt(i));
//			int currentRomanCharNumericValue = currentDigit.getValue();
//
//			if (currentDigit.equals(previousDigit)) {
//				characterRepeatCount++;
//
//				if (characterRepeatCount > 3) {
//					throw new IllegalArgumentException("Repeatable Digit is repeated too often");
//				}
//				if (currentDigit.isRepeatable()) {
//					total += currentRomanCharNumericValue;
//				} else {
//					throw new IllegalArgumentException("Unrepeatable Digit is repeated");
//				}
//			} else if (previousDigit != null && previousDigit.compareTo(currentDigit) < 0) {
//				if (characterRepeatCount > 1) {
//					throw new IllegalArgumentException("Repeatable Digit is repeated before larger digit");
//				}
//				if (previousDigit.subtractableFrom(currentDigit)) {
//					characterRepeatCount = 1;
//					total += currentRomanCharNumericValue - (2 * previousDigit.getValue());
//				} else {
//					throw new IllegalArgumentException("Digit may not be subtracted from other digit");
//				}
//			} else {
//				characterRepeatCount = 1;
//				total += currentRomanCharNumericValue;
//			}
//
//			previousDigit = currentDigit;
//		}
//		return total;
//	}
}
