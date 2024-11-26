package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.TaskDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskDataMapper, Integer> {

}