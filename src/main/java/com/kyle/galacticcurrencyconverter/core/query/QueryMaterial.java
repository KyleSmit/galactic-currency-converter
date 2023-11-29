package com.kyle.galacticcurrencyconverter.core.query;

import com.kyle.galacticcurrencyconverter.core.Content;
import com.kyle.galacticcurrencyconverter.core.unit.BaseUnit;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Map;

@Builder
@Data
public class QueryMaterial implements QueryHandler {

	Content content;
	Map<String, Double> materialValues;
	private final int IS_MARKER = 3;

	public QueryMaterial(Content content, Map<String, Double> materialValues) {
		this.content = content;
		this.materialValues = materialValues;
	}

	@Override
	public void process() {
		StringBuilder queryOutput = new StringBuilder();
		int isPosition = content.getContent().indexOf("IS");
		queryOutput.append(content.getContent().substring(isPosition + IS_MARKER, content.getContent().length() - 1).trim());

		for (int i=IS_MARKER; i < content.getSeperatedContent().length; i++) {
		}
	}
}
