package com.app.quantitymeasurement.controller;

import org.springframework.web.bind.annotation.*;

import com.app.quantitymeasurement.dto.*;
import com.app.quantitymeasurement.service.AuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

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
	public String login(@RequestBody AuthRequestDTO request, HttpServletResponse response) {
		String token = authService.login(request);

		Cookie cookie = new Cookie("jwt", token);

		cookie.setHttpOnly(true);
		cookie.setSecure(false); // true in production
		cookie.setPath("/");
		cookie.setMaxAge(24 * 60 * 60);
		response.addCookie(cookie);

		return "Logged In successfully";
	}

	@PostMapping("/logout")
	public String logout(HttpServletResponse response) {

		Cookie cookie = new Cookie("jwt", null);

		cookie.setHttpOnly(true);
		cookie.setSecure(false);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);

		return "Logged Out successfully";
	}
}