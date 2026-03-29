package com.app.quantitymeasurement.entity;



import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDTO {

    @NotNull(message = "Value cannot be null")
    @Positive(message = "Value must be positive")
    private Double value;

    @NotBlank(message = "Unit cannot be empty")
    private String unit;

    @NotBlank(message = "Measurement type cannot be empty")
    private String measurementType;
}