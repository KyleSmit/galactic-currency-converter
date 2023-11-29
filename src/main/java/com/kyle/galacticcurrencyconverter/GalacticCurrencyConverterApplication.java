package com.kyle.galacticcurrencyconverter;

import com.kyle.galacticcurrencyconverter.processor.InputProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GalacticCurrencyConverterApplication {

	public static void main(String[] args) {

		SpringApplication.run(GalacticCurrencyConverterApplication.class, args);
		new InputProcessor().execute();
	}
}