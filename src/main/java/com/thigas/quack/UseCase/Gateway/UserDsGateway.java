package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;

import java.util.Optional;

public interface UserDsGateway {
    void save(UserDtoRequestModel user);

    Optional<UserDtoRequestModel> findById(int id);

    Boolean existsById(int id);

    Iterable<UserDtoRequestModel> findAll();

    void deleteById(int id);

    Optional<UserDtoRequestModel> findByEmail(String email);

    Optional<UserDtoRequestModel> findByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

}
