package com.thigas.quack.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thigas.quack.infrastructure.persistence.entity.UserModel;

public interface IUserModelRepository extends JpaRepository<UserModel, Long> {
}