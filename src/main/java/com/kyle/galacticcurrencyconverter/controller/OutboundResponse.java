package com.kyle.galacticcurrencyconverter.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutboundResponse {
	private String statusCode;
	private List<String> data;
}
