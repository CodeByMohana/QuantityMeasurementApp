package com.app.quantitymeasurement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.*;

@Configuration
public class SecurityConfig {

	@Autowired
	private OAuth2SuccessHandler oAuth2SuccessHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter filter) throws Exception {
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
				auth -> auth.requestMatchers("/auth/**", "/api/auth/**").permitAll().anyRequest().authenticated())
				.oauth2Login(oauth -> oauth.authorizationEndpoint(auth -> auth.baseUri("/api/auth/login"))
						.redirectionEndpoint(redir -> redir.baseUri("/api/auth/login/code/*"))
						.successHandler(oAuth2SuccessHandler))
				.addFilterBefore(filter,
						org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}