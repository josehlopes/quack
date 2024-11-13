package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.StepDataMapper;
import com.thigas.quack.Infrastructure.Repository.JpaStepRepository;
import com.thigas.quack.UseCase.Gateway.StepDsGateway;
import com.thigas.quack.UseCase.Model.Request.StepDtoRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class StepDsGatewayImplementation implements StepDsGateway {

    private final JpaStepRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(StepDtoRequestModel stepDtoRequest) {
        StepDataMapper toSaveStep = mapper.mapStepDtoRequestToDataMapper(stepDtoRequest);
        repository.save(toSaveStep);
    }

    @Override
    public Optional<StepDtoRequestModel> findById(int id) {
        Optional<StepDataMapper> step = repository.findById(id);
        return step.map(mapper::mapStepDataMapperToDtoRequest);
    }

    @Override
    public Boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<StepDtoRequestModel> findAll() {
        Iterable<StepDataMapper> steps = repository.findAll();
        return StreamSupport.stream(steps.spliterator(), false)
                .map(mapper::mapStepDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}