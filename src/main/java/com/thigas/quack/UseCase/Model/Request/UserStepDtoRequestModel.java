package com.thigas.quack.UseCase.Model.Request;

public record UserStepDtoRequestModel(Integer id, Integer userId, Integer stepId, Integer status, String imagePath) {
}
