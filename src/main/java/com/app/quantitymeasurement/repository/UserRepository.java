package com.app.quantitymeasurement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.quantitymeasurement.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByUsername(String username);
}