package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Model.UserRoadmapDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRoadmapRepository extends JpaRepository<UserRoadmapDataMapper, Integer> {

}