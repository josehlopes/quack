package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.UserAchievementDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserAchievementRepository extends JpaRepository<UserAchievementDataMapper, Integer> {
}
