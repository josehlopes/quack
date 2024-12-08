package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.UserFollowersAndFollowing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonUserFollowersAndFollowingAndFollowing implements UserFollowersAndFollowing {
    private Integer id;
    private Integer followedId;
    private Integer followerId;
    private Boolean isActive;
    
    @Override
    public Boolean setIsActiveStatus(Boolean isActive) {
        this.isActive = isActive;
        return this.isActive;
    }
}
