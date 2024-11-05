package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Entity.UserStepDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserStepRepository extends JpaRepository<UserStepDataMapper, Integer> {
}
