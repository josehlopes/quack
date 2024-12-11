package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.RoadmapDataMapper;
import com.thigas.quack.Adapter.Repository.RoadmapRepository;
import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Mapper.RoadmapMapper;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class RoadmapDsGatewayImplementation implements RoadmapDsGateway {

    private final RoadmapRepository repository;
    private final RoadmapMapper mapper;

    @Override
    public Optional<RoadmapRequestModel> getRoadmapById(Integer id) {
        Optional<RoadmapDataMapper> roadmap = repository.getById(id);
        return roadmap.map(mapper::toDsModel);
    }

    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<RoadmapRequestModel> getAllRoadmaps() {
        Iterable<RoadmapDataMapper> roadmaps = repository.getAll();
        return StreamSupport.stream(roadmaps.spliterator(), false)
                .map(mapper::toDsModel)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<RoadmapRequestModel> getAllRoadmapByCategory(String category) {
        Iterable<RoadmapDataMapper> roadmaps = repository.getByCategory(category);
        return StreamSupport.stream(roadmaps.spliterator(), false)
                .map(mapper::toDsModel)
                .collect(Collectors.toList());
    }
}