package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.UserFollowing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonUserFollowing implements UserFollowing {
    private Integer id;
    private Integer userId;
    private Integer followingId;
    private Boolean isActive;
}
