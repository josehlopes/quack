package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Entity.RoadmapDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoadmapRepository extends JpaRepository<RoadmapDataMapper, Integer> {

}