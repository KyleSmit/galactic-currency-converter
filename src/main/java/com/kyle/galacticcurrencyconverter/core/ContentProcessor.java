package com.kyle.galacticcurrencyconverter.core;

public interface ContentProcessor {


	void loadContent(String input);
	void processContent();

	void processQueryType(Content content);
	void processBaseUnitType(Content content);
}
