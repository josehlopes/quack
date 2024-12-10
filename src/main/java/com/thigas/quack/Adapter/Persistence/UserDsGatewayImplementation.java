package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.UserDataMapper;
import com.thigas.quack.Adapter.Repository.UserRepository;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Mapper.UserMapper;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class UserDsGatewayImplementation implements UserDsGateway {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public void saveUser(UserRequestModel requestModel) {
        UserDataMapper userDataMapper = mapper.toDataMapper(requestModel);
        repository.save(userDataMapper);
    }

    @Override
    public Optional<UserRequestModel> getUserById(Integer id) {
        Optional<UserDataMapper> user = repository.findById(id);
        return user.map(mapper::toDsModel);
    }

    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    public Boolean updateUser(UserRequestModel user) {
        UserDataMapper existingUser = repository.findById(user.id())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        existingUser.setName(user.name());
        existingUser.setSurname(user.surname());
        existingUser.setFullName(user.fullName());
        existingUser.setUsername(user.username());
        existingUser.setPhone(user.phone());
        existingUser.setEmail(user.email());
        existingUser.setBornDate(LocalDate.parse(user.bornDate()));
        existingUser.setRegisterOn(OffsetDateTime.parse(user.registerOn()));
        existingUser.setImagePath(user.imagePath());
        repository.update(existingUser);
        return true;
    }

    @Override
    public Iterable<UserRequestModel> getAllUsers() {
        Iterable<UserDataMapper> users = repository.getAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(mapper::toDsModel)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Optional<UserRequestModel> getByEmail(String email) {
        Optional<UserDataMapper> user = repository.findByEmail(email);
        return user.map(mapper::toDsModel);
    }

    @Override
    public Optional<UserRequestModel> getByUsername(String username) {
        Optional<UserDataMapper> user = repository.findByUsername(username);
        return user.map(mapper::toDsModel);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Boolean deactivateUserById(Integer id) {
        UserDataMapper existingUser = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        existingUser.setIsActive(false);
        repository.update(existingUser);
        return true;
    }
}
