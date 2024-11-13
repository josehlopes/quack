package com.thigas.quack.UseCase.Model.Request;


public record UserRoadmapDtoRequestModel(Integer id, Integer userId, Integer roadmapId, Double progress,
                                         String startedAt, String finishedAt, Integer status) {
}
