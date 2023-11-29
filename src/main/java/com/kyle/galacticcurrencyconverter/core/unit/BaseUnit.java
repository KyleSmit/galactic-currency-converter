package com.kyle.galacticcurrencyconverter.core.unit;

/**
 * Roman Numerals are used as the baseline for unit conversion
 */
public enum BaseUnit {
	I(1, true),
	V(5, false),
	X(10, true),
	L(50, false),
	C(100, true),
	D(500, false),
	M(1000, true);

	private final int value;
	private final boolean repeatable;

	BaseUnit(int value, boolean repeatable) {
		this.value = value;
		this.repeatable = repeatable;
	}

	public int getValue() {
		return value;
	}

	public boolean isRepeatable() {
		return repeatable;
	}

	public boolean subtractableFrom(BaseUnit other) {
		// Currently subtractale digits happen to be the same ones that are repeatable.
		// Should this change, then another solution is needed.
		if (other == null || !this.isRepeatable()) {
			return false;
		}

		int oridinal = this.ordinal();
		int otherOridinal = other.ordinal();

		return (oridinal == otherOridinal - 1 ||  oridinal == otherOridinal - 2);
	}

}
