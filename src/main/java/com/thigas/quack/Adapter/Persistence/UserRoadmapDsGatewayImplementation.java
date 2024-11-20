package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.UserRoadmapDataMapper;
import com.thigas.quack.Adapter.Repository.JpaUserRoadmapRepository;
import com.thigas.quack.UseCase.Gateway.UserRoadmapDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Model.Request.User.UserRoadmapDtoRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserRoadmapDsGatewayImplementation implements UserRoadmapDsGateway {

    private final JpaUserRoadmapRepository repository;
    private final MapStructMapper mapper;

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