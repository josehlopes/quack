package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserRequestModel;

import java.util.Optional;

public interface UserDsGateway {
    void saveUser(UserRequestModel request);
    Optional<UserRequestModel> getUserById(Integer id);
    Boolean existsById(Integer id);
    Optional<UserRequestModel> getByEmail(String email);
    Optional<UserRequestModel> getByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    Iterable<UserRequestModel> getAllUsers();
    Boolean updateUser(UserRequestModel request);
    Boolean deleteUserById(Integer id);
    Boolean deactivateUserById(Integer id);
}
