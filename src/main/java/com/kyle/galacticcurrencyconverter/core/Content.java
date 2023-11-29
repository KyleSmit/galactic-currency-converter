package com.kyle.galacticcurrencyconverter.core;

import com.kyle.galacticcurrencyconverter.core.query.QueryType;
import lombok.Data;


@Data
public class Content {

	private String content;
	private String[] seperatedContent;
	private ContentType contentType;

	public Content(String content) {
		this.content = content;
		this.seperatedContent = content.split("\\s+");
		loadContentType();
	}

	private void loadContentType() {
		String content = this.content.toUpperCase();
		if (content.contains("?") && QueryType.hasQueryValue(content)) {
			this.contentType = ContentType.QUERY;
		} else if (content.contains("IS") && content.contains("CREDIT")) {
			this.contentType = ContentType.UNIT_MATERIAL;
		} else if (content.contains("IS") && !content.contains("CREDIT")) {
			this.contentType = ContentType.UNIT_BASE;
		} else {
			this.contentType = ContentType.INVALID;
		}
	}
}
