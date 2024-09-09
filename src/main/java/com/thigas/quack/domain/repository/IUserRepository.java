package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.User;
import java.util.Optional;

public interface IUserRepository {
    User save(User user);
    //Optional faz com que o retorno possa ser nul
    Optional<User> findById(Long id);
    //metodo do java para foreach para retornar uma coleção
    Iterable<User> findAll();
    void deleteById(Long id);
}
