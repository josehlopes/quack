package com.thigas.quack.UseCase.Model.Request;

public record UserFollowersRequestModel(Integer id, Integer userId, Integer followerId, Boolean isActive) {
}
