package com.kyle.galacticcurrencyconverter.core;

import com.kyle.galacticcurrencyconverter.core.exception.QueryException;
import com.kyle.galacticcurrencyconverter.core.query.QueryFactory;
import com.kyle.galacticcurrencyconverter.core.query.QueryHandler;
import com.kyle.galacticcurrencyconverter.core.query.QueryType;
import com.kyle.galacticcurrencyconverter.core.unit.BaseUnit;
import com.kyle.galacticcurrencyconverter.core.unit.BaseUnitConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public abstract class AbstractProcessor implements ContentProcessor{

	protected List<Content> contentLines = new ArrayList<>();
	protected Map<String, BaseUnit> baseUnitMap = new HashMap<>();
	protected Map<String, Double> unitMaterialMap = new HashMap<>();

	@Override
	public void loadContent(String input) {
		input = sanitizeInput(input);
		contentLines.add(new Content(input));
	}

	@Override
	public void processContent() {

			for (Content content: this.contentLines) {

				if (content.getContentType() != null) {

					switch (content.getContentType()) {
						case QUERY -> processQueryType(content);
						case UNIT_MATERIAL -> processMaterialUnitType(content);
						case UNIT_BASE -> processBaseUnitType(content);
						default -> processInvalidContent();
					}
				} else {
					processInvalidContent();
				}
			}

			log.info("--- Material Map ->");
			unitMaterialMap.forEach((k,v) -> {
				log.info("{} - {}", k, v);
			});

			log.info("--- Base Unit Map ->");
			baseUnitMap.forEach((k,v) -> {
				log.info("{} - {}", k, v);
			});
	}

	@Override
	public void processQueryType(Content content) {

		try {
			Optional<QueryHandler> queryHandler = QueryFactory.getQueryHandler(content, unitMaterialMap, baseUnitMap);

			if (queryHandler.isPresent()) {
				queryHandler.get().process();
			}
		} catch (QueryException qe) {
			log.error(qe.getMessage());
		}
	}

	@Override
	public void processBaseUnitType(Content content) {
		baseUnitMap.put(content.getSeperatedContent()[0], BaseUnit.valueOf(content.getSeperatedContent()[2]));
	}

	public void processMaterialUnitType(Content content) {

		try {
			StringBuilder baseUnitBuilder = new StringBuilder();
			String materialName = "";
			int materialCredit = -1;
			for (int i = 0; i < content.getSeperatedContent().length; i++) {
				BaseUnit baseUnit = baseUnitMap.get(content.getSeperatedContent()[i]);

				if (baseUnit != null) {
					baseUnitBuilder.append(baseUnit);
				} else if ("IS".equals(content.getSeperatedContent()[i])) {
					materialName = content.getSeperatedContent()[i-1];
					materialCredit = Integer.parseInt(content.getSeperatedContent()[i+1]);
				}
			}
			int materialValue = BaseUnitConverter.convertBaseUnit(baseUnitBuilder.toString());

			if (materialValue > -1 && StringUtils.hasText(materialName) && materialCredit > -1) {
				unitMaterialMap.put(materialName, (double) materialCredit/materialValue);
			}
		} catch (Exception e) {
			log.error("Error processing MaterialUnit ->", e);
		}
	}

	public void processInvalidContent() {
		log.error(QueryType.INVALID_QUERY.getValue());
	}


	public String sanitizeInput(String input) {
		return input.trim().toUpperCase();
	}
}
