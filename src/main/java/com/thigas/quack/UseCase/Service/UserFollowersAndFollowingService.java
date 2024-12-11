package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Interface.UserFollowersAndFollowing;
import com.thigas.quack.Domain.Factory.Interface.FollowersAndFollowingFactory;
import com.thigas.quack.UseCase.Boundary.UserFollowersAndFollowingInputBoundary;
import com.thigas.quack.UseCase.Gateway.UserFollowersAndFollowingDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserFollowersAndFollowingRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRelationshipRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@AllArgsConstructor
public class UserFollowersAndFollowingService implements UserFollowersAndFollowingInputBoundary {
    
    private static final Logger logger = LoggerFactory.getLogger(UserFollowersAndFollowingService.class);
    
    private final UserFollowersAndFollowingDsGateway userFollowersAndFollowingDsGateway;
    private final FollowersAndFollowingFactory followersAndFollowingFactory;
    private final GenericPresenter genericPresenter;
    
    @Override
    public void follow(UserRelationshipRequestModel request) {
        UserFollowersAndFollowingRequestModel existingRelationship = userFollowersAndFollowingDsGateway.findFollowerRelationship(request.followedId(), request.followerId());
        if (existingRelationship != null) {
            UserFollowersAndFollowingRequestModel newStatus = changeRelationshipStatus(existingRelationship);
            UserFollowersAndFollowingRequestModel newInverseStatus = changeInverseRelationshipStatus(existingRelationship);
            userFollowersAndFollowingDsGateway.updateFollowerRelationship(newStatus);
            userFollowersAndFollowingDsGateway.updateFollowerRelationship(newInverseStatus);
        } else {
            UserFollowersAndFollowing newRelationship = followersAndFollowingFactory.createRelation(request.followedId(), request.followerId());
            UserFollowersAndFollowingRequestModel createdRelationship = createRequestModel(newRelationship);
            UserFollowersAndFollowingRequestModel createdInverseRelationship = createInverseRequestModel(newRelationship);
            userFollowersAndFollowingDsGateway.saveFollowerRelationship(createdRelationship);
            userFollowersAndFollowingDsGateway.saveFollowerRelationship(createdInverseRelationship);
        }
    }
    
    @Override
    public void unfollow(UserRelationshipRequestModel request) {
        UserFollowersAndFollowingRequestModel existingRelationship = userFollowersAndFollowingDsGateway.findFollowerRelationship(request.followedId(), request.followerId());
        UserFollowersAndFollowingRequestModel existingInverseRelation = userFollowersAndFollowingDsGateway.findFollowerRelationship(request.followerId(), request.followedId());

        if (existingRelationship != null) {
            UserFollowersAndFollowingRequestModel newStatus = changeRelationshipStatus(existingRelationship);
            UserFollowersAndFollowingRequestModel newInverseStatus = changeRelationshipStatus(existingInverseRelation);
            userFollowersAndFollowingDsGateway.updateFollowerRelationship(newStatus);
            userFollowersAndFollowingDsGateway.updateFollowerRelationship(newInverseStatus);
        }
    }
    
    @Override
    public List<UserRequestModel> getFollowers(Integer userId) {
        return userFollowersAndFollowingDsGateway.getFollowers(userId);
    }
    
    @Override
    public List<UserRequestModel> getFollowing(Integer userId) {
        return userFollowersAndFollowingDsGateway.getFollowing(userId);
    }
    
    private UserFollowersAndFollowingRequestModel changeRelationshipStatus(UserFollowersAndFollowingRequestModel userFollowers) {
        return new UserFollowersAndFollowingRequestModel(userFollowers.id(), userFollowers.followedId(), userFollowers.followerId(), !userFollowers.isActive());
    }
    
    private UserFollowersAndFollowingRequestModel changeInverseRelationshipStatus(UserFollowersAndFollowingRequestModel userFollowers) {
        return new UserFollowersAndFollowingRequestModel(userFollowers.id(), userFollowers.followerId(), userFollowers.followedId(), !userFollowers.isActive());
    }
    
    private UserFollowersAndFollowingRequestModel createRequestModel(UserFollowersAndFollowing userFollowersAndFollowing) {
        return new UserFollowersAndFollowingRequestModel(userFollowersAndFollowing.getId(), userFollowersAndFollowing.getFollowerId(), userFollowersAndFollowing.getFollowedId(), userFollowersAndFollowing.getIsActive());
    }
    
    private UserFollowersAndFollowingRequestModel createInverseRequestModel(UserFollowersAndFollowing userFollowersAndFollowing) {
        return new UserFollowersAndFollowingRequestModel(userFollowersAndFollowing.getId(), userFollowersAndFollowing.getFollowedId(), userFollowersAndFollowing.getFollowerId(),  userFollowersAndFollowing.getIsActive());
    }
}