package com.thigas.quack.Domain.Factory.Interface;

import com.thigas.quack.Domain.Entity.Interface.UserFollowersAndFollowing;

public interface FollowersAndFollowingFactory {
    UserFollowersAndFollowing createRelation(Integer followedId, Integer followerId);
}
