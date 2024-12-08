package com.thigas.quack.Domain.Factory.Interface;

import com.thigas.quack.Domain.Entity.Interface.UserFollowers;
import com.thigas.quack.Domain.Entity.Interface.UserFollowing;

public interface UserRelationshipFactory {
    UserFollowers createFollower(Integer userId, Integer followerId);
    UserFollowing createFollowing(Integer userId, Integer followingId);
}
