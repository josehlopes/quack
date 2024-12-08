package com.thigas.quack.Domain.Factory.Implementation;

import com.thigas.quack.Domain.Entity.Implementation.CommonUserFollowers;
import com.thigas.quack.Domain.Entity.Implementation.CommonUserFollowing;
import com.thigas.quack.Domain.Entity.Interface.UserFollowers;
import com.thigas.quack.Domain.Entity.Interface.UserFollowing;
import com.thigas.quack.Domain.Factory.Interface.UserRelationshipFactory;

public class CommonUserRelationshipFactory implements UserRelationshipFactory {
    @Override
    public UserFollowing createFollowing(Integer userId, Integer followingUserId) {
        return new CommonUserFollowing(null, userId, followingUserId, true);
    }

    @Override
    public UserFollowers createFollower(Integer userId, Integer followerUserId) {
        return new CommonUserFollowers(null, userId, followerUserId, true);
    }
}