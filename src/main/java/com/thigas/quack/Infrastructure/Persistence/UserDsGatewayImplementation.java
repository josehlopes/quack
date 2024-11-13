package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Domain.Utils.UsernameGenerator;
import com.thigas.quack.Infrastructure.Entity.UserDataMapper;
import com.thigas.quack.Infrastructure.Repository.JpaUserRepository;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserDsGatewayImplementation implements UserDsGateway {

    private final JpaUserRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(UserDtoRequestModel requestModel) {
        String username = UsernameGenerator.generateUsername(requestModel.name(), requestModel.name());
        UserDataMapper userDataMapper = mapper.mapUserDtoRequestToUserDataMapper(requestModel);
        userDataMapper.setUsername(username);
        repository.save(userDataMapper);
    }

    @Override
    public Optional<UserDtoRequestModel> findById(int id) {
        Optional<UserDataMapper> user = repository.findById(id);
        return user.map(mapper::mapUserDataMapperToUserDtoRequest);
    }

    @Override
    public Boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<UserDtoRequestModel> findAll() {
        Iterable<UserDataMapper> users = repository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(mapper::mapUserDataMapperToUserDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UserDtoRequestModel> findByEmail(String email) {
        Optional<UserDataMapper> user = repository.findByEmail(email);
        return user.map(mapper::mapUserDataMapperToUserDtoRequest);
    }

    @Override
    public Optional<UserDtoRequestModel> findByUsername(String username) {
        Optional<UserDataMapper> user = repository.findByUsername(username);
        return user.map(mapper::mapUserDataMapperToUserDtoRequest);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }
}