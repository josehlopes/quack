package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.StepDataMapper;
import com.thigas.quack.Adapter.Repository.StepRepository;
import com.thigas.quack.UseCase.Gateway.StepDsGateway;
import com.thigas.quack.UseCase.Mapper.StepMapper;
import com.thigas.quack.UseCase.Model.Request.StepRequestModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class StepDsGatewayImplementation implements StepDsGateway {

    private final StepRepository repository;
    private final StepMapper mapper;


    @Override
    public Optional<StepRequestModel> getStepById(Integer id) {
        Optional<StepDataMapper> step = repository.getById(id);
        return step.map(mapper::toDsModel);
    }

    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<StepRequestModel> getAllSteps() {
        Iterable<StepDataMapper> steps = repository.getAll();
        return StreamSupport.stream(steps.spliterator(), false)
                .map(mapper::toDsModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<StepRequestModel> getStepsByRoadmapId(Integer roadmapId) {
        List<StepDataMapper> steps = repository.getStepsByRoadmapId(roadmapId);
        return steps.stream()
                .map(mapper::toDsModel)
                .collect(Collectors.toList());
    }

}