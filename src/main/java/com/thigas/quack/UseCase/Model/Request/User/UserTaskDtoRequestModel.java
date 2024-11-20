package com.thigas.quack.UseCase.Model.Request.User;

public record UserTaskDtoRequestModel(Integer id, Integer userId, Integer taskId, Integer status, String imagePath) {
}