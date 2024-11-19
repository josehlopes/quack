package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.ResultDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserInfoDtoResponseModel;

import java.util.Optional;

//TODO: DEIXAR APENAS MÉTODOS RELACIONADOS A SAÍDA DE DADOS
//TODO: MÉTODO FINDBYEMAIL ESTÁ VOLTANDO UM DS (DATA SOURCE) POR CAUSA QUE PRECISO DA SENHA PARA COMPARAR NO LOGIN
//TODO: GETBYID RETORNMANDO DS POR QUE PRECISO PARA FAZER UPDATE
public interface UserDsGateway {
    void save(UserDsDtoRequestModel user);

    Optional<UserDsDtoRequestModel> getById(int id);
    Boolean findById(int id);
    Optional<UserDsDtoRequestModel> getByEmail(String email);
    Optional<UserDsDtoRequestModel> getByUsername(String username);
    Boolean findByEmail(String email);
    Boolean findByUsername(String username);
    Iterable<UserDsDtoRequestModel> getAll();

    Boolean update(UserDsDtoRequestModel user);

    void deleteById(int id);
}
