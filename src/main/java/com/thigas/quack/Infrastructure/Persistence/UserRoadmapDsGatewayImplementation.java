package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.UseCase.Gateway.UserRoadmapDsGateway;
import com.thigas.quack.Infrastructure.Entity.UserRoadmapDataMapper;
import com.thigas.quack.Infrastructure.Repository.JpaUserRoadmapRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserRoadmapDsGatewayImplementation implements UserRoadmapDsGateway {

    @Autowired
    private JpaUserRoadmapRepository userRoadmapModelRepository;

    @Override
    public void save(UserRoadmapDataMapper userRoadmapDataMapper) {
        userRoadmapModelRepository.save(userRoadmapDataMapper);
    }

    @Override
    public Optional<UserRoadmapDataMapper> findById(int id) {
        return userRoadmapModelRepository.findById(id);
    }

    @Override
    public List<UserRoadmapDataMapper> findAll() {
        return userRoadmapModelRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        userRoadmapModelRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return userRoadmapModelRepository.existsById(id);
    }
}
