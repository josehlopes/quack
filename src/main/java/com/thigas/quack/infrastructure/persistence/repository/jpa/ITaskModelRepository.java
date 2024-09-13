package com.thigas.quack.infrastructure.persistence.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thigas.quack.infrastructure.persistence.entity.TaskModel;

public interface ITaskModelRepository extends JpaRepository<TaskModel, Integer> {

}