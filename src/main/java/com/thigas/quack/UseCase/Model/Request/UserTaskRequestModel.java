package com.thigas.quack.UseCase.Model.Request;

public record UserTaskRequestModel(Integer id, Integer userId, Integer taskId, Integer status, String imagePath) {
}