package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Model.UserAchievementDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserAchievementRepository extends JpaRepository<UserAchievementDataMapper, Integer> {
}
