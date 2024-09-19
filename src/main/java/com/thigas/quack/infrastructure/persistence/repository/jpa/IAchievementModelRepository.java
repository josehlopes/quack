package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAchievementModelRepository extends JpaRepository<AchievementModel, Integer> {

}