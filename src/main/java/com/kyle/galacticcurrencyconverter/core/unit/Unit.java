package com.kyle.galacticcurrencyconverter.core.unit;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Unit  {

	private String symbol;
	private int value;
	private boolean repeatable;



}
