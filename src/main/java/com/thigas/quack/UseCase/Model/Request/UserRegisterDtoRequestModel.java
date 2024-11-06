package com.thigas.quack.UseCase.Model.Request;

public record UserRegisterDtoRequestModel(String name, String phone, String email, String password, String cpf, String bornDate, String imagePath) {
}
