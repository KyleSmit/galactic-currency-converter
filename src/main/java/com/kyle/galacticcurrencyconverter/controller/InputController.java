package com.kyle.galacticcurrencyconverter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/api/v1")
@Slf4j
public class InputController {

	@PostMapping(value = "/processNotes")
	public ResponseEntity<OutboundResponse> processNotes(@RequestBody InboundRequest request) {
		log.info("InboundRequest [{}] ", request);
		// Todo: Implement processor for web request..
		return ResponseEntity.ok(new OutboundResponse("200", Arrays.asList("Test")));
	}
}
