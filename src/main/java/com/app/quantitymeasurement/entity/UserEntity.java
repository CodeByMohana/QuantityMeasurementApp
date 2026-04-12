package com.app.quantitymeasurement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = true)
	private String password;

	@Column(unique = true, nullable = true)
	private String email;

	@Column(nullable = false)
	private String provider;
}