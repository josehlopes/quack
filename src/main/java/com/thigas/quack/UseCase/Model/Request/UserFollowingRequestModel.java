package com.thigas.quack.UseCase.Model.Request;

public record UserFollowingRequestModel(Integer id, Integer userId, Integer followingId, Boolean isActive) {
}
