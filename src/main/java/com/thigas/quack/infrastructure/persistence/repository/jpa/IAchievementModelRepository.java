package com.thigas.quack.infrastructure.persistence.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;

public interface IAchievementModelRepository extends JpaRepository<AchievementModel, Integer> {

}