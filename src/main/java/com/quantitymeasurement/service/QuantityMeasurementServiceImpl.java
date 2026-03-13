package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.QuantityDTO;
import com.quantitymeasurement.model.Quantity;
import com.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.quantitymeasurement.units.*;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

	private final IQuantityMeasurementRepository repository;

	public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
		this.repository = repository;
	}

	private IMeasurable getUnit(String unit, String type) {

		return switch (type.toUpperCase()) {

		case "LENGTH" -> LengthUnit.valueOf(unit.toUpperCase());
		case "WEIGHT" -> WeightUnit.valueOf(unit.toUpperCase());
		case "VOLUME" -> VolumeUnit.valueOf(unit.toUpperCase());
		case "TEMPERATURE" -> TemperatureUnit.valueOf(unit.toUpperCase());

		default -> throw new IllegalArgumentException("Invalid type");
		};
	}

	private Quantity<?> buildQuantity(QuantityDTO dto) {

		IMeasurable unit = getUnit(dto.getUnit(), dto.getMeasurementType());

		return new Quantity<>(dto.getValue(), unit);
	}

	@Override
	public boolean compare(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		return a.equals(b);
	}

	@SuppressWarnings("unchecked")
	private <U extends IMeasurable> Quantity<U> cast(Quantity<?> quantity) {
		return (Quantity<U>) quantity;
	}

	@Override
	public QuantityDTO convert(QuantityDTO q, String targetUnit) {

		Quantity<?> quantity = buildQuantity(q);

		IMeasurable unit = getUnit(targetUnit, q.getMeasurementType());

		Quantity<?> result = cast(quantity).convertTo(unit);

		return new QuantityDTO(result.getValue(), targetUnit, q.getMeasurementType());
	}

	@Override
	public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		Quantity<?> result = cast(a).add(cast(b));

		return new QuantityDTO(result.getValue(), result.getUnit().getUnitName(), q1.getMeasurementType());
	}

	@Override
	public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		Quantity<?> result = cast(a).subtract(cast(b));

		return new QuantityDTO(result.getValue(), result.getUnit().getUnitName(), q1.getMeasurementType());
	}

	@Override
	public double divide(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		return cast(a).divide(cast(b));
	}
}