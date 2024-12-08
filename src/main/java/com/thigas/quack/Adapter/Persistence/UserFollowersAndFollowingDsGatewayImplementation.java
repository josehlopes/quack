package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.UserDataMapper;
import com.thigas.quack.Adapter.Entity.UserFollowersAndFollowingDataMapper;
import com.thigas.quack.Adapter.Repository.UserRelationshipRepository;
import com.thigas.quack.UseCase.Gateway.UserFollowersAndFollowingDsGateway;
import com.thigas.quack.UseCase.Mapper.UserMapper;
import com.thigas.quack.UseCase.Mapper.UserFollowersAndFollowingMapper;
import com.thigas.quack.UseCase.Model.Request.UserFollowersAndFollowingRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserFollowersAndFollowingDsGatewayImplementation implements UserFollowersAndFollowingDsGateway {
    
    private final UserRelationshipRepository repository;
    private final UserFollowersAndFollowingMapper mapper;
    private final UserMapper userMapper;
    
    @Override
    public List<UserRequestModel> getFollowers(Integer userId) {
        List<UserDataMapper> followers = repository.getAllFollowers(userId);
        return followers.stream()
                .map(userMapper::toDsModel)
                .collect(Collectors.toList());
    }
    
    

    @Override
    public List<UserRequestModel> getFollowing(Integer userId) {
        List<UserDataMapper> followings = repository.getAllFollowing(userId);
        return followings.stream()
                .map(userMapper::toDsModel)
                .collect(Collectors.toList());
    }
    
    @Override
    public UserFollowersAndFollowingRequestModel findFollowerRelationship(Integer userId, Integer followerId) {
        return mapper.toDsModel(repository.findFollowerRelationship(userId, followerId));
    }
    
    @Override
    public void updateFollowerRelationship(UserFollowersAndFollowingRequestModel userFollowers) {
        UserFollowersAndFollowingDataMapper toUpdateUserFollowers = mapper.toDataMapper(userFollowers);
        repository.updateFollower(toUpdateUserFollowers);
    }
    
    @Override
    public void saveFollowerRelationship(UserFollowersAndFollowingRequestModel userFollowers) {
        UserFollowersAndFollowingDataMapper toSaveUserFollowers = mapper.toDataMapper(userFollowers);
        repository.saveFollower(toSaveUserFollowers);
    }
}