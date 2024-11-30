package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Mapper.RoadmapMapper;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class RoadmapService {

    private final RoadmapDsGateway roadmapDsGateway;
    private final GenericPresenter genericPresenter;
    private final RoadmapMapper roadmapMapper;

    public ResponseWrapper<GenericResponseModel> getById(Integer id) {
        Optional<RoadmapRequestModel> roadmap = roadmapDsGateway.getById(id);

        if (roadmap.isEmpty()) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Roadmap not found"), 404);
        }

        Map<String, Object> payload = Map.of("roadmap", roadmap.get());
        return genericPresenter.prepareSuccessView(new GenericResponseModel("Roadmap found", payload), 200);
    }

    public ResponseWrapper<GenericResponseModel> getAll() {
        Iterable<RoadmapRequestModel> roadmaps = roadmapDsGateway.getAll();
        Iterable<RoadmapRequestModel> roadmapList = StreamSupport.stream(roadmaps.spliterator(), false)
                .collect(Collectors.toList());

        if (!roadmapList.iterator().hasNext()) {
            return genericPresenter.prepareFailView(new GenericResponseModel("No roadmaps available"), 204);
        }

        Map<String, Object> payload = Map.of("roadmaps", roadmapList);
        return genericPresenter.prepareSuccessView(new GenericResponseModel("All roadmaps retrieved", payload), 200);
    }

    public ResponseWrapper<GenericResponseModel> existsById(Integer roadmapId) {
        boolean exists = roadmapDsGateway.existsById(roadmapId);

        if (!exists) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Roadmap does not exist"), 404);
        }

        return genericPresenter.prepareSuccessView(new GenericResponseModel("Roadmap exists"), 200);
    }
}
