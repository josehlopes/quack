package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.RoadmapDataMapper;
import com.thigas.quack.Adapter.Repository.JpaRoadmapRepository;
import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class RoadmapDsGatewayImplementation implements RoadmapDsGateway {

    private final JpaRoadmapRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(RoadmapRequestModel roadmapDtoRequest) {
        RoadmapDataMapper toSaveRoadmap = mapper.mapRoadmapDtoRequestToDataMapper(roadmapDtoRequest);
        repository.save(toSaveRoadmap);
    }

    @Override
    public Optional<RoadmapRequestModel> findById(int id) {
        Optional<RoadmapDataMapper> roadmap = repository.findById(id);
        return roadmap.map(mapper::mapRoadmapDataMapperToDtoRequest);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<RoadmapRequestModel> findAll() {
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