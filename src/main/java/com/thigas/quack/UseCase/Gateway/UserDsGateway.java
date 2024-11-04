package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.Infrastructure.Model.UserDataMapper;
import com.thigas.quack.UseCase.Model.Request.UserDsRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserResponseModel;

import java.util.Optional;

public interface UserDsGateway {
    void save(UserDsRequestModel user);
    Optional<UserDsRequestModel> findById(int id);
    boolean existsById(int id);
    Iterable<UserDsRequestModel> findAll();
    void deleteById(int id);
    Optional<UserDsRequestModel> findByEmail(String email);
    Optional<UserDsRequestModel> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

}
