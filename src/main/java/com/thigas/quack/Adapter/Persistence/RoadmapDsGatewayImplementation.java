package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.RoadmapDataMapper;
import com.thigas.quack.Adapter.Repository.RoadmapRepository;
import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class RoadmapDsGatewayImplementation implements RoadmapDsGateway {

    private final RoadmapRepository repository;
    private final MapStructMapper mapper;


    @Override
    public Optional<RoadmapRequestModel> findById(Integer id) {
        Optional<RoadmapDataMapper> roadmap = repository.findById(id);
        return roadmap.map(mapper::mapRoadmapDataMapperToDtoRequest);
    }

    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<RoadmapRequestModel> findAll() {
        Iterable<RoadmapDataMapper> roadmaps = repository.findAll();
        return StreamSupport.stream(roadmaps.spliterator(), false)
                .map(mapper::mapRoadmapDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

}