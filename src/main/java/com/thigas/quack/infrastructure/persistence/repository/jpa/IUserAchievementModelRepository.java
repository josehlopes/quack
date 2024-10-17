package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAchievementModelRepository extends JpaRepository<UserAchievementModel, Integer> {
}
