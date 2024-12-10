package com.thigas.quack.Domain.Entity.Interface;

public interface UserFollowersAndFollowing {
    Integer getId();
    Integer getFollowedId();
    Integer getFollowerId();
    Boolean getIsActive();
    
    Boolean setIsActiveStatus(Boolean isActive);
}
