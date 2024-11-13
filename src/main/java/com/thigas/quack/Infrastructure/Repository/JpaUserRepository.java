package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Entity.UserDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserDataMapper, Integer> {
    Optional<UserDataMapper> findByEmail(String email);

    Optional<UserDataMapper> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}