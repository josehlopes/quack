package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.RoadmapMapper;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IRoadmapModelRepository;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserModelRepository;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserRoadmapModelRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RoadmapRepositoryImplementation implements IRoadmapRepository {

    private final RoadmapMapper userMapper = RoadmapMapper.INSTANCE;
    @Autowired
    private IRoadmapModelRepository roadmapModelRepository;

    @Autowired
    private IUserModelRepository userModelRepository;

    @Autowired
    private IUserRoadmapModelRepository userRoadmapModelRepository;

    @Override
    @Transactional
    public RoadmapEntity save(RoadmapEntity roadmapEntity) {
        RoadmapModel roadmapModel = userMapper.entityToModel(roadmapEntity);
        RoadmapModel savedRoadmapModel = roadmapModelRepository.save(roadmapModel);
        return userMapper.modelToEntity(savedRoadmapModel);
    }

    @Override
    @Transactional
    public Optional<RoadmapEntity> findById(int id) {
        return roadmapModelRepository.findById(id).map(userMapper::modelToEntity);
    }

    @Override
    @Transactional
    public Iterable<RoadmapEntity> findAll() {
        return roadmapModelRepository.findAll().stream().map(userMapper::modelToEntity).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        roadmapModelRepository.deleteById(id);
    }
}
