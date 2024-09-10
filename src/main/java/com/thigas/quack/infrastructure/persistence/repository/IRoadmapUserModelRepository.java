package com.thigas.quack.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thigas.quack.infrastructure.persistence.entity.RoadmapUserModel;

public interface IRoadmapUserModelRepository extends JpaRepository<RoadmapUserModel, Long> {

}