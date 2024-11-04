package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Infrastructure.Model.UserStepDataMapper;
import com.thigas.quack.UseCase.Gateway.UserStepDsGateway;

import com.thigas.quack.Infrastructure.Repository.JpaUserStepRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserStepDsGatewayImplementation implements UserStepDsGateway {

    @Autowired
    private JpaUserStepRepository userStepModelRepository;

    @Override
    public void save(UserStepDataMapper userRoadmapModel) {
         userStepModelRepository.save(userRoadmapModel);
    }

    @Override
    public Optional<UserStepDataMapper> findById(int id) {
        return userStepModelRepository.findById(id);
    }

    @Override
    public List<UserStepDataMapper> findAll() {
        return userStepModelRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        userStepModelRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return userStepModelRepository.existsById(id);
    }
}
