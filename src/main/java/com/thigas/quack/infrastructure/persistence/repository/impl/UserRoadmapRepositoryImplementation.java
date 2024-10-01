package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.StatisticsMapper;
import com.thigas.quack.adapter.mapper.UserRoadmapMapper;
import com.thigas.quack.domain.repository.IUserRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserRoadmapModelRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRoadmapRepositoryImplementation implements IUserRoadmapRepository {


    @Autowired
    private UserRoadmapMapper userRoadmapMapper;    @Autowired

    private IUserRoadmapModelRepository userRoadmapModelRepository;

    @Override
    @Transactional
    public UserRoadmapModel save(UserRoadmapModel userRoadmapModel) {
        return userRoadmapModelRepository.save(userRoadmapModel);
    }

    @Override
    @Transactional
    public Optional<UserRoadmapModel> findById(int id) {
        return userRoadmapModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Iterable<UserRoadmapModel> findAll() {
        return userRoadmapModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userRoadmapModelRepository.deleteById(id);
    }
}
