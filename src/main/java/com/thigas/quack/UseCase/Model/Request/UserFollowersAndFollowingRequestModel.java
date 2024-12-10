package com.thigas.quack.UseCase.Model.Request;

public record UserFollowersAndFollowingRequestModel(Integer id, Integer followedId, Integer followerId, Boolean isActive) {
}
