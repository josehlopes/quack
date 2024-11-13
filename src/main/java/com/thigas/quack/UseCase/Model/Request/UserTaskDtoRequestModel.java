package com.thigas.quack.UseCase.Model.Request;

public record UserTaskDtoRequestModel(Integer id, Integer userId, Integer taskId, Integer status, String imagePath) {
}