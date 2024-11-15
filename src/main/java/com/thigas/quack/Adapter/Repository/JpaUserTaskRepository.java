package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.UserTaskDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserTaskRepository extends JpaRepository<UserTaskDataMapper, Integer> {
}