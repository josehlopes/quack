package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Entity.TaskDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskDataMapper, Integer> {

}