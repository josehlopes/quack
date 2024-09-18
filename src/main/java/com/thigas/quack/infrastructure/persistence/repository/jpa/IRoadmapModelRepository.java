package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoadmapModelRepository extends JpaRepository<RoadmapModel, Integer> {

}