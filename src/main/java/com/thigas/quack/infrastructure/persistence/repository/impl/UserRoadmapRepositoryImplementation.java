package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.domain.repository.IUserRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserRoadmapModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRoadmapRepositoryImplementation implements IUserRoadmapRepository {

    @Autowired
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
    public List<UserRoadmapModel> findAll() {
        return userRoadmapModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userRoadmapModelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean existsById(int id) {
        return userRoadmapModelRepository.existsById(id);
    }
}
