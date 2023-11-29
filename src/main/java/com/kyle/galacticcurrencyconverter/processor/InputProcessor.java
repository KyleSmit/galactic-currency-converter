package com.kyle.galacticcurrencyconverter.processor;

import com.kyle.galacticcurrencyconverter.config.SystemConfig;
import com.kyle.galacticcurrencyconverter.core.AbstractProcessor;
import com.kyle.galacticcurrencyconverter.core.Content;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Slf4j
@Component
public class InputProcessor extends AbstractProcessor {

	public void execute() {
		try (Stream<String> lines = Files.lines(Paths.get(getClass().getClassLoader()
				.getResource("TestInputFile.txt").toURI()))) {

			lines.toList().forEach(line -> {
				log.info("Processing line:" + line);
				super.loadContent(line);
			});
			processContent();
		} catch (IOException ioe) {
			log.error("Error reading file ->", ioe);
		} catch (URISyntaxException urise) {
			log.error("Error generating input file uri ->", urise);
		}
	}

	@Override
	public void processContent() {
		super.processContent();

	}
}
