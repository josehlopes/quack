package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.AchievementDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAchievementRepository extends JpaRepository<AchievementDataMapper, Integer> {

}