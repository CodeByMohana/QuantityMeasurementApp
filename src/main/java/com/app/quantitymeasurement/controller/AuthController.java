package com.app.quantitymeasurement.controller;

import org.springframework.web.bind.annotation.*;

import com.app.quantitymeasurement.dto.*;
import com.app.quantitymeasurement.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/register")
	public String register(@RequestBody RegisterRequestDTO request) {
		authService.register(request);
		return "User Registered Successfully";
	}

	@PostMapping("/login")
	public AuthResponseDTO login(@RequestBody AuthRequestDTO request) {
		String token = authService.login(request);
		return new AuthResponseDTO(token);
	}
}