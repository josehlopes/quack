package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.UserRelationshipRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;

import java.util.List;

public interface UserFollowersAndFollowingInputBoundary {
    void follow(UserRelationshipRequestModel request);
    void unfollow(UserRelationshipRequestModel request);
    List<UserRequestModel> getFollowers(Integer userId);
    List<UserRequestModel> getFollowing(Integer userId);
}
