package com.thigas.quack.UseCase.Model.Request;

public record UserDsRequestModel(Integer id, String name, String surname, String fullName, String username,
                                 String phone, String email, String password, String cpf,
                                 String bornDate, String registerOn, String imagePath, Boolean isActive) {
}
