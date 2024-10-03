package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.UserModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserModelRepository extends JpaRepository<UserModel, Integer> {
	Optional<UserModel> findByEmail(String email);
}