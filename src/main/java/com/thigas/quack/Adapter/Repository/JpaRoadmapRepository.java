package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.RoadmapDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoadmapRepository extends JpaRepository<RoadmapDataMapper, Integer> {

}