package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.UserFollowers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonUserFollowers implements UserFollowers {
    private Integer id;
    private Integer userId;
    private Integer followerId;
    private Boolean isActive;
    
    @Override
    public Boolean setIsActiveStatus(Boolean isActive) {
        this.isActive = isActive;
        return this.isActive;
    }
}
