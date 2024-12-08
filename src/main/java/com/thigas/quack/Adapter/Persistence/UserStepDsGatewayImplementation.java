package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.UserStepDataMapper;
import com.thigas.quack.Adapter.Repository.JpaUserStepRepository;
import com.thigas.quack.UseCase.Gateway.UserStepDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Model.Request.UserStepRequestModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserStepDsGatewayImplementation implements UserStepDsGateway {

    private final JpaUserStepRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(UserStepRequestModel userStepDtoRequest) {
        UserStepDataMapper toSaveUserStep = mapper.mapUserStepDtoRequestToDataMapper(userStepDtoRequest);
        repository.save(toSaveUserStep);
    }

    @Override
    public Optional<UserStepRequestModel> findById(Integer id) {
        Optional<UserStepDataMapper> userStep = repository.findById(id);
        return userStep.map(mapper::mapUserStepDataMapperToDtoRequest);
    }

    @Override
    public List<UserStepRequestModel> findAll() {
        List<UserStepDataMapper> userSteps = repository.findAll();
        return userSteps.stream()
                .map(mapper::mapUserStepDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }
}