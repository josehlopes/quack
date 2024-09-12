package com.thigas.quack.infrastructure.persistence.repository.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.RoadmapMapper;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IRoadmapModelRepository;

@Repository
public class RoadmapRepositoryImplementation implements IRoadmapRepository {

    @Autowired
    private IRoadmapModelRepository roadmapModelRepository;
    private final RoadmapMapper userMapper = RoadmapMapper.INSTANCE;

    @Override
    public RoadmapEntity save(RoadmapEntity roadmap) {
        RoadmapModel roadmapModel = userMapper.toRoadmapModel(roadmap);
        RoadmapModel savedRoadmapModel = roadmapModelRepository.save(roadmapModel);
        return userMapper.toRoadmap(savedRoadmapModel);
    }

    @Override
    public Optional<RoadmapEntity> findById(int id) {
        return roadmapModelRepository.findById(id).map(userMapper::toRoadmap);
    }

    @Override
    public Iterable<RoadmapEntity> findAll() {
        return roadmapModelRepository.findAll().stream()
                .map(userMapper::toRoadmap)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        roadmapModelRepository.deleteById(id);
    }
}
