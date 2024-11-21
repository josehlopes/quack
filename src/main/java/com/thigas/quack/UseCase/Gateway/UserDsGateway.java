package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserDsRequestModel;

import java.util.Optional;

//TODO: DEIXAR APENAS MÉTODOS RELACIONADOS A SAÍDA DE DADOS
//TODO: MÉTODO FINDBYEMAIL ESTÁ VOLTANDO UM DS (DATA SOURCE) POR CAUSA QUE PRECISO DA SENHA PARA COMPARAR NO LOGIN
//TODO: GETBYID RETORNMANDO DS POR QUE PRECISO PARA FAZER UPDATE
public interface UserDsGateway {
    void save(UserDsRequestModel user);

    Optional<UserDsRequestModel> getById(Integer id);

    Boolean findById(Integer id);

    Optional<UserDsRequestModel> getByEmail(String email);

    Optional<UserDsRequestModel> getByUsername(String username);

    Boolean findByEmail(String email);

    Boolean findByUsername(String username);

    Iterable<UserDsRequestModel> getAll();

    Boolean update(UserDsRequestModel user);

    Boolean deleteById(Integer id);
}
