package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class RoadmapService {

    private final RoadmapDsGateway roadmapDsGateway;

    private final UserDsGateway userDsGateway;

    public void create(RoadmapRequestModel roadmapDtoRequest) {
        roadmapDsGateway.save(roadmapDtoRequest);
    }

    public Optional<RoadmapRequestModel> getById(int id) {
        return roadmapDsGateway.findById(id);
    }

    public Iterable<RoadmapRequestModel> getAll() {
        Iterable<RoadmapRequestModel> roadmaps = roadmapDsGateway.findAll();
        return StreamSupport.stream(roadmaps.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(RoadmapRequestModel roadmapDtoRequest) {
        RoadmapRequestModel existingRoadmap = roadmapDsGateway.findById(roadmapDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Roadmap not found"));
        RoadmapRequestModel updatedRoadmap = new RoadmapRequestModel(
                roadmapDtoRequest.id(),
                roadmapDtoRequest.title() != null ? roadmapDtoRequest.title() : existingRoadmap.title(),
                roadmapDtoRequest.description() != null ? roadmapDtoRequest.description() : existingRoadmap.description(),
                roadmapDtoRequest.imagePath() != null ? roadmapDtoRequest.imagePath() : existingRoadmap.imagePath(),
                roadmapDtoRequest.status() != null ? roadmapDtoRequest.status() : existingRoadmap.status(),
                roadmapDtoRequest.stepsIds() != null ? roadmapDtoRequest.stepsIds() : existingRoadmap.stepsIds()
        );
        roadmapDsGateway.save(updatedRoadmap);
    }

    public void delete(int id) {
        roadmapDsGateway.deleteById(id);
    }

    public Boolean existsById(int roadmapId) {
        return userDsGateway.findById(roadmapId);
    }
}