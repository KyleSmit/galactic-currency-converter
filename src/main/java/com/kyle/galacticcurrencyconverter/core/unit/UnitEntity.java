package com.kyle.galacticcurrencyconverter.core.unit;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "unit")
public class UnitEntity  {
	@Id
	Long id;
	private String symbol;
	private Integer value;
	private boolean repeatable;
}
