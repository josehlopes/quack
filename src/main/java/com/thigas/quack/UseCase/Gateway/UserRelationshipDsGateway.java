package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.Domain.Entity.Interface.User;
import com.thigas.quack.Domain.Entity.Interface.UserFollowers;
import com.thigas.quack.UseCase.Model.Request.UserFollowersRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRelationshipRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;

import java.util.List;

public interface UserRelationshipDsGateway {
    List<UserRequestModel> getFollowers(Integer userId);
    List<UserRequestModel> getFollowing(Integer userId);
    UserFollowersRequestModel findFollowerRelationship(Integer userId, Integer followerId);
    void updateFollowerRelationship(UserFollowersRequestModel userFollowers);
    void saveFollowerRelationship(UserFollowersRequestModel userFollowers);
}
