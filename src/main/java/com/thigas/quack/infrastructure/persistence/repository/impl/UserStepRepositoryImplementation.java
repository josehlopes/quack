package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.domain.repository.IUserStepRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserStepModel;

import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserStepModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserStepRepositoryImplementation implements IUserStepRepository {

    @Autowired
    private IUserStepModelRepository userStepModelRepository;

    @Override
    @Transactional
    public UserStepModel save(UserStepModel userRoadmapModel) {
        return userStepModelRepository.save(userRoadmapModel);
    }

    @Override
    @Transactional
    public Optional<UserStepModel> findById(int id) {
        return userStepModelRepository.findById(id);
    }

    @Override
    @Transactional
    public List<UserStepModel> findAll() {
        return userStepModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userStepModelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean existsById(int id) {
        return userStepModelRepository.existsById(id);
    }
}
