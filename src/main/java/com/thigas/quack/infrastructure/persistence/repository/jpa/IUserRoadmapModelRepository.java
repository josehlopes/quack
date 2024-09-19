package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRoadmapModelRepository extends JpaRepository<UserRoadmapModel, Integer> {

}