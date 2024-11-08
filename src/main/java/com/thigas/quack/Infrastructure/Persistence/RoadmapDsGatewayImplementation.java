package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.RoadmapDataMapper;
import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaRoadmapRepository;
import com.thigas.quack.UseCase.Model.Request.RoadmapDtoRequestModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RoadmapDsGatewayImplementation implements RoadmapDsGateway {

    final JpaRoadmapRepository repository;
    private final MapStructMapper mapper;

    public RoadmapDsGatewayImplementation(JpaRoadmapRepository repository, MapStructMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

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