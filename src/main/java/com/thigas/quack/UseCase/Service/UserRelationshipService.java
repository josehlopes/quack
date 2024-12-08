package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Interface.User;
import com.thigas.quack.Domain.Entity.Interface.UserFollowers;
import com.thigas.quack.Domain.Factory.Interface.UserRelationshipFactory;
import com.thigas.quack.UseCase.Boundary.UserRelationshipInputBoundary;
import com.thigas.quack.UseCase.Gateway.UserRelationshipDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserFollowersRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRelationshipRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@AllArgsConstructor
public class UserRelationshipService implements UserRelationshipInputBoundary {
    
    private static final Logger logger = LoggerFactory.getLogger(UserRelationshipService.class);
    
    private final UserRelationshipDsGateway userRelationshipDsGateway;
    private final UserRelationshipFactory userRelationshipFactory;
    private final GenericPresenter genericPresenter;
    
    @Override
    public void follow(UserRelationshipRequestModel request) {
        UserFollowersRequestModel existingRelationship = userRelationshipDsGateway.findFollowerRelationship(request.followedId(), request.followerId());
        if (existingRelationship != null) {
            UserFollowersRequestModel newStatus = changeRelationshipStatus(existingRelationship);
            userRelationshipDsGateway.updateFollowerRelationship(newStatus);
        } else {
            UserFollowers newRelationship = userRelationshipFactory.createFollower(request.followedId(), request.followerId());
            UserFollowersRequestModel createdRelationship = createRequestModel(newRelationship);
            userRelationshipDsGateway.saveFollowerRelationship(createdRelationship);
        }
    }
    
    @Override
    public void unfollow(UserRelationshipRequestModel request) {
        UserFollowersRequestModel existingRelationship = userRelationshipDsGateway.findFollowerRelationship(request.followedId(), request.followerId());
        if (existingRelationship != null) {
            UserFollowersRequestModel newStatus = changeRelationshipStatus(existingRelationship);
            userRelationshipDsGateway.updateFollowerRelationship(newStatus);
        }
    }
    
    @Override
    public List<UserRequestModel> getFollowers(Integer userId) {
        return userRelationshipDsGateway.getFollowers(userId);
    }
    
    @Override
    public List<UserRequestModel> getFollowing(Integer userId) {
        return userRelationshipDsGateway.getFollowing(userId);
    }
    
    private UserFollowersRequestModel changeRelationshipStatus(UserFollowersRequestModel userFollowers) {
        UserFollowersRequestModel newRelationship = new UserFollowersRequestModel(userFollowers.id(), userFollowers.userId(), userFollowers.followerId(), !userFollowers.isActive());
        return userFollowers;
    }
    
    private UserFollowersRequestModel createRequestModel(UserFollowers userFollowers) {
        return new UserFollowersRequestModel(userFollowers.getId(), userFollowers.getFollowerId(), userFollowers.getUserId(), userFollowers.getIsActive());
    }
    
    
}