package com.thigas.quack.UseCase.Model.Response;

//TODO: POSSÍVEL RECORD PARA BUSCAR INFORMAÇÕES PARA A TELA DE PERFIL DO USUÁRIO
public record UserInfoDtoResponseModel(Integer id, String name, String email, String registerOn, String imagePath, Integer rankPosition, Integer bestStreak,
                                       Integer userLevel, Integer challengesCompletedCount, Integer roadmapsCompletedCount) {
}
