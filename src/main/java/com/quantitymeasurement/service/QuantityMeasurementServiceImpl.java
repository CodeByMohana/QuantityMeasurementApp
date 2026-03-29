package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.QuantityDTO;
import com.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.quantitymeasurement.model.Quantity;
import com.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.quantitymeasurement.unit.*;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

	private final IQuantityMeasurementRepository repository;

	public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
		this.repository = repository;
	}

	/**
	 * Returns correct unit enum based on measurement type
	 */
	private IMeasurable getUnit(String unit, String type) {

		return switch (type.toUpperCase()) {

		case "LENGTH" -> LengthUnit.valueOf(unit.toUpperCase());
		case "WEIGHT" -> WeightUnit.valueOf(unit.toUpperCase());
		case "VOLUME" -> VolumeUnit.valueOf(unit.toUpperCase());
		case "TEMPERATURE" -> TemperatureUnit.valueOf(unit.toUpperCase());

		default -> throw new IllegalArgumentException("Invalid measurement type");
		};
	}

	/**
	 * Build Quantity object from DTO
	 */
	private Quantity<?> buildQuantity(QuantityDTO dto) {

		IMeasurable unit = getUnit(dto.getUnit(), dto.getMeasurementType());

		return new Quantity<>(dto.getValue(), unit);
	}

	/**
	 * Cast helper
	 */
	@SuppressWarnings("unchecked")
	private <U extends IMeasurable> Quantity<U> cast(Quantity<?> quantity) {
		return (Quantity<U>) quantity;
	}

	/**
	 * Compare quantities
	 */
	@Override
	public boolean compare(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		boolean result = a.equals(b);

		QuantityMeasurementEntity entity = new QuantityMeasurementEntity("COMPARE", q1.getMeasurementType(),
				q1.getValue(), q1.getUnit(), q2.getValue(), q2.getUnit(), result ? 1 : 0, "BOOLEAN");
		repository.save(entity);

		return result;
	}

	/**
	 * Convert quantity
	 */
	@Override
	public QuantityDTO convert(QuantityDTO q, String targetUnit) {

		Quantity<?> quantity = buildQuantity(q);

		IMeasurable unit = getUnit(targetUnit, q.getMeasurementType());

		Quantity<?> result = cast(quantity).convertTo(unit);
		QuantityMeasurementEntity entity = new QuantityMeasurementEntity("CONVERT", q.getMeasurementType(),
				q.getValue(), q.getUnit(), null, null, result.getValue(), targetUnit);
		repository.save(entity);

		return new QuantityDTO(result.getValue(), targetUnit, q.getMeasurementType());
	}

	/**
	 * Add quantities
	 */
	@Override
	public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		Quantity<?> result = cast(a).add(cast(b));
		QuantityMeasurementEntity entity = new QuantityMeasurementEntity("ADD", q1.getMeasurementType(), q1.getValue(),
				q1.getUnit(), q2.getValue(), q2.getUnit(), result.getValue(), result.getUnit().getUnitName());
		repository.save(entity);

		return new QuantityDTO(result.getValue(), result.getUnit().getUnitName(), q1.getMeasurementType());
	}

	/**
	 * Subtract quantities
	 */
	@Override
	public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		Quantity<?> result = cast(a).subtract(cast(b));

		QuantityMeasurementEntity entity = new QuantityMeasurementEntity("SUBTRACT", q1.getMeasurementType(),
				q1.getValue(), q1.getUnit(), q2.getValue(), q2.getUnit(), result.getValue(),
				result.getUnit().getUnitName());
		repository.save(entity);

		return new QuantityDTO(result.getValue(), result.getUnit().getUnitName(), q1.getMeasurementType());
	}

	/**
	 * Divide quantities
	 */
	@Override
	public double divide(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		double result = cast(a).divide(cast(b));

		QuantityMeasurementEntity entity = new QuantityMeasurementEntity("DIVIDE", q1.getMeasurementType(),
				q1.getValue(), q1.getUnit(), q2.getValue(), q2.getUnit(), result, "SCALAR");
		repository.save(entity);

		return result;
	}
}