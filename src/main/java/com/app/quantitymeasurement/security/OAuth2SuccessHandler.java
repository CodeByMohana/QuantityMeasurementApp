package com.app.quantitymeasurement.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.app.quantitymeasurement.entity.UserEntity;
import com.app.quantitymeasurement.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

	private final JwtUtil jwtUtil;
	private final UserRepository userRepository;

	public OAuth2SuccessHandler(JwtUtil jwtUtil, UserRepository userRepository) {
		this.jwtUtil = jwtUtil;
		this.userRepository = userRepository;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
		String email = oAuth2User.getAttribute("email");
		String name = oAuth2User.getAttribute("name");

		UserEntity user = userRepository.findByEmail(email).orElseGet(() -> {
			UserEntity newUser = new UserEntity();
			newUser.setEmail(email);
			newUser.setUsername(name);
			newUser.setProvider("GOOGLE");
			return userRepository.save(newUser);
		});

		String token = jwtUtil.generateToken(user.getEmail());

		Cookie cookie = new Cookie("jwt", token);
		cookie.setHttpOnly(true);
		cookie.setSecure(false);
		cookie.setPath("/");
		cookie.setMaxAge(24 * 60 * 60);

		response.addCookie(cookie);

		response.sendRedirect("http://localhost:3000/home");
	}

}
