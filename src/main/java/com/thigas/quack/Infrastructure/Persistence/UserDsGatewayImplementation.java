package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Domain.Utils.UsernameGenerator;
import com.thigas.quack.Infrastructure.Entity.UserDataMapper;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaUserRepository;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;

public class UserDsGatewayImplementation implements UserDsGateway {


    final JpaUserRepository repository;


    @Autowired
    private ObjectMapperService objectMapperService;

    public UserDsGatewayImplementation(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(UserDtoRequestModel requestModel) {
        String username = UsernameGenerator.generateUsername(requestModel.getName(), requestModel.getCpf());

        UserDataMapper accountDataMapper = new UserDataMapper(
                requestModel.getId(),
                requestModel.getName(),
                username,
                requestModel.getPhone(),
                requestModel.getEmail(),
                requestModel.getPassword(),
                requestModel.getCpf(),
                requestModel.getBornDate(),
                requestModel.getRegisterOn(),
                requestModel.getStatus(),
                requestModel.getImagePath()
        );
        repository.save(accountDataMapper);
    }

    @Override
    public Optional<UserDtoRequestModel> findById(int id) {
        return repository.findById(id)
                .map(objectMapperService::toEntity);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<UserDtoRequestModel> findAll() {
        return repository.findAll()
                .stream()
                .map(objectMapperService::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UserDtoRequestModel> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(objectMapperService::toEntity);
    }

    @Override
    public Optional<UserDtoRequestModel> findByUsername(String username) {
        return repository.findByUsername(username)
                .map(objectMapperService::toEntity);
    }

    //TODO: Implementar métodos
    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }
}
