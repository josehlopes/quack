package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Entity.AchievementDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAchievementRepository extends JpaRepository<AchievementDataMapper, Integer> {

}