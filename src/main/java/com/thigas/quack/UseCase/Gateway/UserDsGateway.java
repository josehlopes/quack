package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserRequestModel;

import java.util.Optional;

public interface UserDsGateway {
    void save(UserRequestModel dataSourceModel);

    Optional<UserRequestModel> getById(Integer id);

    Boolean findById(Integer id);

    Optional<UserRequestModel> getByEmail(String email);

    Optional<UserRequestModel> getByUsername(String username);

    Boolean findByEmail(String email);

    Boolean findByUsername(String username);

    Iterable<UserRequestModel> getAll();

    Boolean update(UserRequestModel dataSourceModel);

    Boolean deleteById(Integer id);
}
