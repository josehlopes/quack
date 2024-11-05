package com.thigas.quack.UseCase.Model.Request;

public record UserDtoRequestModel(Integer id, String name, String phone, String email, String password, String cpf, String bornDate, String registerOn, String imagePath, Integer status) {
}
