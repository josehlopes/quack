package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.RoadmapMapper;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;


import java.util.Map;
import java.util.Optional;


@AllArgsConstructor
public class RoadmapService {

    private final RoadmapDsGateway roadmapDsGateway;
    private final UserDsGateway userDsGateway;
    private final GenericPresenter genericPresenter;
    private final RoadmapMapper roadmapMapper;

    public ResponseWrapper<GenericResponseModel> getById(int id) {
        Optional<RoadmapRequestModel> roadmap = roadmapDsGateway.findById(id);

        if (roadmap.isEmpty()) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Roadmap not found"), 404);
        }

        // Envolvendo o roadmap em um Map
        Map<String, Object> payload = Map.of("roadmap", roadmap.get());

        return genericPresenter.prepareSuccessView(new GenericResponseModel("Roadmap found", payload), 200);
    }

    public ResponseWrapper<GenericResponseModel> getAll() {
        Iterable<RoadmapRequestModel> roadmaps = roadmapDsGateway.findAll();

        // Envolvendo os roadmaps em um Map
        Map<String, Object> payload = Map.of("roadmaps", roadmaps);

        return genericPresenter.prepareSuccessView(new GenericResponseModel("All roadmaps", payload), 200);
    }


    public Boolean existsById(int roadmapId) {
        return userDsGateway.findById(roadmapId);
    }
}