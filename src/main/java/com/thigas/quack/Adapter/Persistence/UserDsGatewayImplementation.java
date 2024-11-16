package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.Domain.Utils.UsernameGenerator;
import com.thigas.quack.Adapter.Entity.UserDataMapper;
import com.thigas.quack.Adapter.Repository.UserRepository;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserDsGatewayImplementation implements UserDsGateway {

    private final UserRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(UserDtoRequestModel requestModel) {
        String username = UsernameGenerator.generateUsername(requestModel.name(), requestModel.name());
        UserDataMapper userDataMapper = mapper.mapUserDtoRequestToUserDataMapper(requestModel);
        userDataMapper.setUsername(username);
        repository.save(userDataMapper);
    }

    //TODO:RESOLVER O DATAPARSE ERROR
    @Override
    public Optional<UserDtoRequestModel> getById(int id) {
        Optional<UserDataMapper> user = repository.findById(id);
        return user.map(mapper::mapUserDataMapperToUserDtoRequest);
    }

    @Override
    public Boolean findById(int id) {
        return repository.existsById(id);
    }
    public Boolean update(UserDtoRequestModel user) {
        UserDataMapper existingUser = repository.findById(user.id())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        existingUser.setName(user.name());
        existingUser.setPhone(user.phone());
        existingUser.setEmail(user.email());
        existingUser.setBornDate(LocalDate.parse(user.bornDate()));
        existingUser.setRegisterOn(OffsetDateTime.parse(user.registerOn()));
        existingUser.setImagePath(user.imagePath());
        repository.update(existingUser);
        return true;
    }

    @Override
    public Iterable<UserDtoRequestModel> getAll() {
        Iterable<UserDataMapper> users = repository.getAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(mapper::mapUserDataMapperToUserDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UserDtoRequestModel> getByEmail(String email) {
        Optional<UserDataMapper> user = repository.findByEmail(email);
        return user.map(mapper::mapUserDataMapperToUserDtoRequest);
    }

    @Override
    public Optional<UserDtoRequestModel> getByUsername(String username) {
        Optional<UserDataMapper> user = repository.findByUsername(username);
        return user.map(mapper::mapUserDataMapperToUserDtoRequest);
    }

    @Override
    public Boolean findByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Boolean findByUsername(String username) {
        return repository.existsByUsername(username);
    }
}