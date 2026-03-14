CREATE TABLE IF NOT EXISTS quantity_measurements (
    id INT AUTO_INCREMENT PRIMARY KEY,

    operation_type VARCHAR(50),
    measurement_type VARCHAR(50),

    operand1_value DOUBLE,
    operand1_unit VARCHAR(50),

    operand2_value DOUBLE,
    operand2_unit VARCHAR(50),

    result_value DOUBLE,
    result_unit VARCHAR(50),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);