package com.kyle.galacticcurrencyconverter.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor()
@NoArgsConstructor()
@Setter()
@Getter()
public class InboundRequest {

	private List<String> lines;
}
