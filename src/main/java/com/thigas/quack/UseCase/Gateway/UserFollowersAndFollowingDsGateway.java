package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.UserFollowersAndFollowingRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;

import java.util.List;

public interface UserFollowersAndFollowingDsGateway {
    List<UserRequestModel> getFollowers(Integer userId);
    List<UserRequestModel> getFollowing(Integer userId);
    UserFollowersAndFollowingRequestModel findFollowerRelationship(Integer userId, Integer followerId);
    void updateFollowerRelationship(UserFollowersAndFollowingRequestModel userFollowers);
    void saveFollowerRelationship(UserFollowersAndFollowingRequestModel userFollowers);
}
