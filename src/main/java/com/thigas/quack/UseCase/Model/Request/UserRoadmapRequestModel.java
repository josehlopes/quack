package com.thigas.quack.UseCase.Model.Request;


public record UserRoadmapRequestModel(Integer id, Integer userId, Integer roadmapId, Double progress,
                                      String startedIn, String finishedIn, Integer status) {
}
