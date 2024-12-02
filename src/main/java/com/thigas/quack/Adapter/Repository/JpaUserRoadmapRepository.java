package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.UserRoadmapDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRoadmapRepository extends JpaRepository<UserRoadmapDataMapper, Integer> {

}