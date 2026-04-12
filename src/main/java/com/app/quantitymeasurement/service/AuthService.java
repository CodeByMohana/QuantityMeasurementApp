package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.dto.*;

public interface AuthService {
	void register(RegisterRequestDTO request);

	String login(AuthRequestDTO request);
}