package com.thigas.quack.UseCase.Model.Request;

public record UserRegisterRequestModel(String name, String surname, String phone, String email, String password,
                                       String cpf, String bornDate, String imagePath) {
}
