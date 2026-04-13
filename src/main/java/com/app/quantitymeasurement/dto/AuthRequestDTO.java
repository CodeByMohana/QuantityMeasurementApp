package com.app.quantitymeasurement.dto;

import lombok.Data;

@Data
public class AuthRequestDTO {
	private String username;
	private String password;
	private String email;
}
