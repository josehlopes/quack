package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.RoadmapDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class RoadmapService {

    private final RoadmapDsGateway roadmapDsGateway;

    private final UserDsGateway userDsGateway;

    public void create(RoadmapDtoRequestModel roadmapDtoRequest) {
        roadmapDsGateway.save(roadmapDtoRequest);
    }

    public Optional<RoadmapDtoRequestModel> getById(int id) {
        return roadmapDsGateway.findById(id);
    }

    public Iterable<RoadmapDtoRequestModel> getAll() {
        Iterable<RoadmapDtoRequestModel> roadmaps = roadmapDsGateway.findAll();
        return StreamSupport.stream(roadmaps.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(RoadmapDtoRequestModel roadmapDtoRequest) {
        RoadmapDtoRequestModel existingRoadmap = roadmapDsGateway.findById(roadmapDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Roadmap not found"));
        RoadmapDtoRequestModel updatedRoadmap = new RoadmapDtoRequestModel(
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
        return userDsGateway.existsById(roadmapId);
    }
}