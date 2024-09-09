package com.thigas.quack.infrastructure.persistence.repository;

import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserModelRepository extends JpaRepository<UserModel, Long> {
    // JpaRepository fornece implementações básicas para CRUD
}