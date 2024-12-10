package com.thigas.quack.Domain.Factory.Implementation;

import com.thigas.quack.Domain.Entity.Implementation.CommonUserFollowersAndFollowingAndFollowing;
import com.thigas.quack.Domain.Entity.Interface.UserFollowersAndFollowing;
import com.thigas.quack.Domain.Factory.Interface.FollowersAndFollowingFactory;

public class CommonFollowersAndFollowingFactory implements FollowersAndFollowingFactory {
    @Override
    public UserFollowersAndFollowing createRelation(Integer followedId, Integer followerUserId) {
        return new CommonUserFollowersAndFollowingAndFollowing(null, followedId, followerUserId, true);
    }
}