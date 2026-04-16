package com.app.quantitymeasurement.controller;

import org.springframework.web.bind.annotation.*;

import com.app.quantitymeasurement.dto.*;
import com.app.quantitymeasurement.service.AuthService;

import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping(value = {"/register", "/signup"})
	public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequestDTO request) {
		authService.register(request);
		return ResponseEntity.ok(Map.of("message", "User Registered Successfully"));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
		String token = authService.login(request);
		return ResponseEntity.ok(new AuthResponseDTO(token));
	}

	@PostMapping("/logout")
	public ResponseEntity<Map<String, String>> logout() {
		return ResponseEntity.ok(Map.of("message", "Logged Out successfully"));
	}

	@GetMapping("/profile")
	public ResponseEntity<Map<String, String>> profile() {
		org.springframework.security.core.Authentication auth = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
		return ResponseEntity.ok(Map.of("username", auth.getName()));
	}
}