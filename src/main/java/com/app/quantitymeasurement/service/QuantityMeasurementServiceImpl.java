package com.app.quantitymeasurement.service;

import org.springframework.stereotype.Service;

import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.repository.QuantityMeasurementRepository;
import com.app.quantitymeasurement.unit.*;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

	private final QuantityMeasurementRepository repository;
	private final com.app.quantitymeasurement.repository.UserRepository userRepository;

	public QuantityMeasurementServiceImpl(QuantityMeasurementRepository repository, com.app.quantitymeasurement.repository.UserRepository userRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
	}

	// ---------------------------
	// UNIT RESOLUTION
	// ---------------------------
	private IMeasurable getUnit(String unit, String type) {
		return switch (type.toUpperCase()) {
		case "LENGTH" -> LengthUnit.valueOf(unit.toUpperCase());
		case "WEIGHT" -> WeightUnit.valueOf(unit.toUpperCase());
		case "VOLUME" -> VolumeUnit.valueOf(unit.toUpperCase());
		case "TEMPERATURE" -> TemperatureUnit.valueOf(unit.toUpperCase());
		default -> throw new IllegalArgumentException("Invalid measurement type");
		};
	}

	private Quantity<?> buildQuantity(QuantityDTO dto) {
		IMeasurable unit = getUnit(dto.getUnit(), dto.getMeasurementType());
		return new Quantity<>(dto.getValue(), unit);
	}

	@SuppressWarnings("unchecked")
	private <U extends IMeasurable> Quantity<U> cast(Quantity<?> quantity) {
		return (Quantity<U>) quantity;
	}

	// ---------------------------
	// COMPARE
	// ---------------------------
	@Override
	public boolean compare(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		boolean result = a.equals(b);

		saveEntity("COMPARE", q1, q2, null, null);

		return result;
	}

	// ---------------------------
	// CONVERT
	// ---------------------------
	@Override
	public QuantityDTO convert(QuantityDTO q, String targetUnit) {

		Quantity<?> quantity = buildQuantity(q);
		IMeasurable unit = getUnit(targetUnit, q.getMeasurementType());

		Quantity<?> result = cast(quantity).convertTo(unit);

		saveEntity("CONVERT", q, null, result.getValue(), targetUnit);

		return new QuantityDTO(result.getValue(), targetUnit, q.getMeasurementType());
	}

	// ---------------------------
	// ADD
	// ---------------------------
	@Override
	public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		Quantity<?> result = cast(a).add(cast(b));

		saveEntity("ADD", q1, q2, result.getValue(), result.getUnit().getUnitName());

		return new QuantityDTO(result.getValue(), result.getUnit().getUnitName(), q1.getMeasurementType());
	}

	// ---------------------------
	// SUBTRACT
	// ---------------------------
	@Override
	public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		Quantity<?> result = cast(a).subtract(cast(b));

		saveEntity("SUBTRACT", q1, q2, result.getValue(), result.getUnit().getUnitName());

		return new QuantityDTO(result.getValue(), result.getUnit().getUnitName(), q1.getMeasurementType());
	}

	// ---------------------------
	// DIVIDE
	// ---------------------------
	@Override
	public double divide(QuantityDTO q1, QuantityDTO q2) {

		Quantity<?> a = buildQuantity(q1);
		Quantity<?> b = buildQuantity(q2);

		double result = cast(a).divide(cast(b));

		saveEntity("DIVIDE", q1, q2, result, "SCALAR");

		return result;
	}

	// ---------------------------
	// HISTORY
	// ---------------------------
	@Override
	public java.util.List<QuantityMeasurementEntity> getHistory() {
		return repository.findByUserId(getCurrentUserId());
	}

	// ---------------------------
	// SAVE TO DATABASE
	// ---------------------------
	private void saveEntity(String operation, QuantityDTO q1, QuantityDTO q2, Double resultValue, String resultUnit) {

		QuantityMeasurementEntity entity = QuantityMeasurementEntity.builder().operationType(operation)
				.measurementType(q1.getMeasurementType()).operand1Value(q1.getValue()).operand1Unit(q1.getUnit())
				.operand2Value(q2 != null ? q2.getValue() : null).operand2Unit(q2 != null ? q2.getUnit() : null)
				.resultValue(resultValue).resultUnit(resultUnit)
				.userId(getCurrentUserId()).build();

		repository.save(entity);
	}

	private Long getCurrentUserId() {
		org.springframework.security.core.Authentication auth = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
			return null;
		}
		return userRepository.findByEmail(auth.getName()).map(com.app.quantitymeasurement.entity.UserEntity::getId).orElse(null);
	}
}