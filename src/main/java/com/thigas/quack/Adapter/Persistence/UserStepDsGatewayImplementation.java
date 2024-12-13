package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.UserStepDataMapper;
import com.thigas.quack.Adapter.Repository.UserStepRepository;
import com.thigas.quack.UseCase.Gateway.UserStepDsGateway;
import com.thigas.quack.UseCase.Mapper.UserStepMapper;
import com.thigas.quack.UseCase.Model.Request.UserStepRequestModel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserStepDsGatewayImplementation implements UserStepDsGateway {

    private final UserStepRepository repository;
    private final UserStepMapper mapper;

    @Override
    public void save(UserStepRequestModel userStepDtoRequest) {
        UserStepDataMapper toSaveUserStep = mapper.toDataMapper(userStepDtoRequest);
        repository.save(toSaveUserStep);
    }

    @Override
    public void update(UserStepRequestModel userStepDtoRequest) {
        UserStepDataMapper userStepToUpdate = mapper.toDataMapper(userStepDtoRequest);
        repository.update(userStepToUpdate);
    }

    @Override
    public List<UserStepRequestModel> getStepsByUserId(Integer userId) {
        List<UserStepDataMapper> userSteps = repository.getUserStepsByUserId(userId);
        return userSteps.stream()
                .map(mapper::toDsModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserStepRequestModel> getById(Integer id) {
        Optional<UserStepDataMapper> userStep = repository.getById(id);
        return userStep.map(mapper::toDsModel);
    }

    @Override
    public List<UserStepRequestModel> getAll() {
        List<UserStepDataMapper> userSteps = (List<UserStepDataMapper>) repository.getAllUserSteps();
        return userSteps.stream()
                .map(mapper::toDsModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }
}