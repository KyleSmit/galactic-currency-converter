package com.kyle.galacticcurrencyconverter.core.query;

import com.kyle.galacticcurrencyconverter.core.Content;
import com.kyle.galacticcurrencyconverter.core.exception.QueryException;
import com.kyle.galacticcurrencyconverter.core.unit.BaseUnit;

import java.util.Map;
import java.util.Optional;

public class QueryFactory {

	public static Optional<QueryHandler> getQueryHandler(Content content, Map<String,Double> unitMaterialMap, Map<String, BaseUnit> baseUnitMap) throws QueryException  {

		QueryType queryType = QueryType.getType(content.getContent());
		switch (queryType) {
			case HOW_MANY -> {
				return Optional.of(new QueryMaterial(content, unitMaterialMap));
			} case HOW_MUCH -> {
				return Optional.of(new QueryUnit(content, baseUnitMap));
			}
			default -> throw new QueryException(queryType.getValue());
		}
	}
}
