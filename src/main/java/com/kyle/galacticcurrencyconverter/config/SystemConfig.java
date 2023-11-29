package com.kyle.galacticcurrencyconverter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class SystemConfig {

	@Value("${system.app.messageSource}")
	private String messageSource;
	@Value("${system.app.unitSource:ENUM}")
	private String unitSource;
}
