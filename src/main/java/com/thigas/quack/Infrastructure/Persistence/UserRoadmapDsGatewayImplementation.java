package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.UserRoadmapDataMapper;
import com.thigas.quack.UseCase.Gateway.UserRoadmapDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaUserRoadmapRepository;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapDtoRequestModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRoadmapDsGatewayImplementation implements UserRoadmapDsGateway {

    final JpaUserRoadmapRepository repository;
    private final MapStructMapper mapper;

    public UserRoadmapDsGatewayImplementation(JpaUserRoadmapRepository repository, MapStructMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(UserRoadmapDtoRequestModel userRoadmapDtoRequest) {
        UserRoadmapDataMapper toSaveUserRoadmap = mapper.mapUserRoadmapDtoRequestToDataMapper(userRoadmapDtoRequest);
        repository.save(toSaveUserRoadmap);
    }

    @Override
    public Optional<UserRoadmapDtoRequestModel> findById(int id) {
        Optional<UserRoadmapDataMapper> userRoadmap = repository.findById(id);
        return userRoadmap.map(mapper::mapUserRoadmapDataMapperToDtoRequest);
    }

    @Override
    public List<UserRoadmapDtoRequestModel> findAll() {
        List<UserRoadmapDataMapper> userRoadmaps = repository.findAll();
        return userRoadmaps.stream()
                .map(mapper::mapUserRoadmapDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }
}