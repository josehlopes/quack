package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;

import java.util.Optional;

public interface UserDsGateway {
    void save(UserDtoRequestModel user);
    Boolean update(UserDtoRequestModel user);
    Optional<UserDtoRequestModel> getById(int id);
    Boolean findById(int id);
    Iterable<UserDtoRequestModel> getAll();
    void deleteById(int id);
    Optional<UserDtoRequestModel> getByEmail(String email);
    Optional<UserDtoRequestModel> getByUsername(String username);
    Boolean findByEmail(String email);
    Boolean findByUsername(String username);
}
