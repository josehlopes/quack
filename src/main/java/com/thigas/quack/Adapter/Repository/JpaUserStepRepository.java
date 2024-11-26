package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.UserStepDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserStepRepository extends JpaRepository<UserStepDataMapper, Integer> {
}
