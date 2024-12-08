package com.thigas.quack.Domain.Entity.Interface;

public interface UserFollowers {
    Integer getId();
    Integer getUserId();
    Integer getFollowerId();
    Boolean getIsActive();
    
    Boolean setIsActiveStatus(Boolean isActive);
}
