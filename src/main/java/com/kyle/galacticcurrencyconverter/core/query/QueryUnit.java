package com.kyle.galacticcurrencyconverter.core.query;

import com.kyle.galacticcurrencyconverter.core.Content;
import com.kyle.galacticcurrencyconverter.core.unit.BaseUnit;

import java.util.Map;

public class QueryUnit implements QueryHandler{

	Content content;
	Map<String, BaseUnit> baseUnitMap;

	public QueryUnit(Content content, Map<String, BaseUnit> baseUnitMap) {
		this.content = content;
		this.baseUnitMap = baseUnitMap;
	}

	@Override
	public void process() {


	}
}
