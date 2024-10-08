package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.RoadmapMapper;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IRoadmapModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RoadmapRepositoryImplementation implements IRoadmapRepository {

    private final RoadmapMapper userMapper = RoadmapMapper.INSTANCE;
    @Autowired
    private IRoadmapModelRepository roadmapModelRepository;

    @Override
    public RoadmapEntity save(RoadmapEntity roadmapEntity) {
        RoadmapModel roadmapModel = userMapper.entityToModel(roadmapEntity);
        RoadmapModel savedRoadmapModel = roadmapModelRepository.save(roadmapModel);
        return userMapper.modelToEntity(savedRoadmapModel);
    }

    @Override
    public Optional<RoadmapEntity> findById(int id) {
        return roadmapModelRepository.findById(id).map(userMapper::modelToEntity);
    }

    @Override
    public Iterable<RoadmapEntity> findAll() {
        return roadmapModelRepository.findAll().stream().map(userMapper::modelToEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        roadmapModelRepository.deleteById(id);
    }
}
