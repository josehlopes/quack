package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.UserStepDataMapper;
import com.thigas.quack.UseCase.Gateway.UserStepDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaUserStepRepository;
import com.thigas.quack.UseCase.Model.Request.UserStepDtoRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserStepDsGatewayImplementation implements UserStepDsGateway {

    private final JpaUserStepRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(UserStepDtoRequestModel userStepDtoRequest) {
        UserStepDataMapper toSaveUserStep = mapper.mapUserStepDtoRequestToDataMapper(userStepDtoRequest);
        repository.save(toSaveUserStep);
    }

    @Override
    public Optional<UserStepDtoRequestModel> findById(int id) {
        Optional<UserStepDataMapper> userStep = repository.findById(id);
        return userStep.map(mapper::mapUserStepDataMapperToDtoRequest);
    }

    @Override
    public List<UserStepDtoRequestModel> findAll() {
        List<UserStepDataMapper> userSteps = repository.findAll();
        return userSteps.stream()
                .map(mapper::mapUserStepDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }
}