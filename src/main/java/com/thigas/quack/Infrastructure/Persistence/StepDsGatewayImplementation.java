package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.StepDataMapper;
import com.thigas.quack.UseCase.Gateway.StepDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaStepRepository;
import com.thigas.quack.UseCase.Model.Request.StepDtoRequestModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class StepDsGatewayImplementation implements StepDsGateway {

    final JpaStepRepository repository;
    private final MapStructMapper mapper;

    public StepDsGatewayImplementation(JpaStepRepository repository, MapStructMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

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