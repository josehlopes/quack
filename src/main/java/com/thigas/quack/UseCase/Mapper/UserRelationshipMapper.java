package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.UserFollowersDataMapper;
import com.thigas.quack.Adapter.Entity.UserFollowingDataMapper;
import com.thigas.quack.UseCase.Model.Request.UserFollowersRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserFollowingRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRelationshipRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface UserRelationshipMapper {
    
    UserRelationshipMapper MAPPER = Mappers.getMapper(UserRelationshipMapper.class);
    
    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "followerId", source = "follower.id"),
    })
    UserFollowersRequestModel toDsModel(UserFollowersDataMapper userFollowersDataMapper);
    
    @Mappings({
            @Mapping(target = "user.id", source = "userId"),
            @Mapping(target = "follower.id", source = "followerId"),
    })
    UserFollowersDataMapper toDataMapper(UserFollowersRequestModel userRelationshipRequestModel);
    
    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "followingId", source = "following.id"),
    })
    UserFollowingRequestModel toDsModel(UserFollowingDataMapper userFollowersDataMapper);
    
    @Mappings({
            @Mapping(target = "user.id", source = "userId"),
            @Mapping(target = "following.id", source = "followingId"),
    })
    UserFollowingDataMapper toDataMapper(UserFollowingRequestModel userRelationshipRequestModel);
    
    
}
