package com.kyle.galacticcurrencyconverter.core.unit;

import com.kyle.galacticcurrencyconverter.config.SystemConfig;
import com.kyle.galacticcurrencyconverter.core.exception.ApplicationException;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

@Component
public class UnitManager {

	UnitRepository repo;
	private final SystemConfig systemConfig;

	@Getter
	private Map<String, Unit> units = new HashMap<>();


	public UnitManager(SystemConfig systemConfig) throws ApplicationException {
		this.systemConfig = systemConfig;
		loadUnits();
	}

	public void loadUnits() throws ApplicationException {

		UnitSource unitSource = UnitSource.valueOf(systemConfig.getUnitSource());
		switch (unitSource) {
			case DB -> StreamSupport.stream(repo.findAll().spliterator(), false)
					.forEach(u -> this.units.put(u.getSymbol(), new Unit(u.getSymbol(), u.getValue(),u.isRepeatable())));
			case ENUM -> Arrays.stream(BaseUnit.values())
					.forEach(u -> this.units.put(u.name(), new Unit(u.name(), u.getValue(), u.isRepeatable())));
			default -> throw new ApplicationException("Error -> Unit configuration not defined");
		}
	}

}
