package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.RoadmapDataMapper;
import com.thigas.quack.Infrastructure.Repository.JpaRoadmapRepository;
import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Model.Request.RoadmapDtoRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class RoadmapDsGatewayImplementation implements RoadmapDsGateway {

    private final JpaRoadmapRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(RoadmapDtoRequestModel roadmapDtoRequest) {
        RoadmapDataMapper toSaveRoadmap = mapper.mapRoadmapDtoRequestToDataMapper(roadmapDtoRequest);
        repository.save(toSaveRoadmap);
    }

    @Override
    public Optional<RoadmapDtoRequestModel> findById(int id) {
        Optional<RoadmapDataMapper> roadmap = repository.findById(id);
        return roadmap.map(mapper::mapRoadmapDataMapperToDtoRequest);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<RoadmapDtoRequestModel> findAll() {
        Iterable<RoadmapDataMapper> roadmaps = repository.findAll();
        return StreamSupport.stream(roadmaps.spliterator(), false)
                .map(mapper::mapRoadmapDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}