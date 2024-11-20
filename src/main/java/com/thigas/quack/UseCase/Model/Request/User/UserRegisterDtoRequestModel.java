package com.thigas.quack.UseCase.Model.Request.User;

public record UserRegisterDtoRequestModel(String name, String surname, String phone, String email, String password,
                                          String cpf,
                                          String bornDate, String imagePath) {
}
