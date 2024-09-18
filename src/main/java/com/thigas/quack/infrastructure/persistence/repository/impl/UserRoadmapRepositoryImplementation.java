package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.UserRoadmapMapper;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.domain.repository.IUserRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserRoadmapModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRoadmapRepositoryImplementation implements IUserRoadmapRepository {

    private final UserRoadmapMapper userRoadmapMapper = UserRoadmapMapper.INSTANCE;
    @Autowired
    private IUserRoadmapModelRepository userRoadmapModelRepository;

    @Override
    public UserRoadmapEntity save(UserRoadmapEntity userRoadmapEntity) {
        UserRoadmapModel userRoadmapMODEL = userRoadmapMapper.entityToModel(userRoadmapEntity);
        UserRoadmapModel savedUserRoadmapModel = userRoadmapModelRepository.save(userRoadmapMODEL);
        return userRoadmapMapper.modelToEntity(savedUserRoadmapModel);
    }

    @Override
    public Optional<UserRoadmapEntity> findById(int id) {
        return userRoadmapModelRepository.findById(id).map(userRoadmapMapper::modelToEntity);
    }

    @Override
    public Iterable<UserRoadmapEntity> findAll() {
        return userRoadmapModelRepository.findAll().stream().map(userRoadmapMapper::modelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        userRoadmapModelRepository.deleteById(id);
    }
}
