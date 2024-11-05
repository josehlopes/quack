package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Entity.UserTaskDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserTaskRepository extends JpaRepository<UserTaskDataMapper, Integer> {
}