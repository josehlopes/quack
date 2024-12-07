package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.StatisticsDataMapper;
import com.thigas.quack.Adapter.Entity.UserRoadmapDataMapper;
import com.thigas.quack.Adapter.Repository.UserRoadmapRepository;
import com.thigas.quack.UseCase.Gateway.UserRoadmapDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Mapper.RoadmapMapper;
import com.thigas.quack.UseCase.Mapper.UserRoadmapMapper;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserRoadmapDsGatewayImplementation implements UserRoadmapDsGateway {

    private final UserRoadmapRepository repository;
    private final UserRoadmapMapper mapper;
    private final RoadmapMapper roadmapMapper;

    @Override
    public Boolean saveUserRoadmap(UserRoadmapRequestModel userRoadmapDtoRequest) {
        UserRoadmapDataMapper toSaveUserRoadmap = mapper.toDataMapper(userRoadmapDtoRequest);
        return repository.save(toSaveUserRoadmap);
    }

    @Override
    public UserRoadmapRequestModel updateUserRoadmap(UserRoadmapRequestModel userRoadmap) {
        UserRoadmapDataMapper userRoadmapDataMapper = mapper.toDataMapper(userRoadmap);
        repository.update(userRoadmapDataMapper);
        return userRoadmap;
    }

    @Override
    public Optional<UserRoadmapRequestModel> getUserRoadmapById(Integer id) {
        Optional<UserRoadmapDataMapper> userRoadmap = repository.getById(id);
        return userRoadmap.map(mapper::toDsModel);
    }

}