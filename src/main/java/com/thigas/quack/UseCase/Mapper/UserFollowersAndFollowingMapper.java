package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.UserFollowersAndFollowingDataMapper;
import com.thigas.quack.UseCase.Model.Request.UserFollowersAndFollowingRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface UserFollowersAndFollowingMapper {
    
    UserFollowersAndFollowingMapper MAPPER = Mappers.getMapper(UserFollowersAndFollowingMapper.class);
    
    @Mappings({
            @Mapping(target = "followedId", source = "followed.id"),
            @Mapping(target = "followerId", source = "follower.id"),
    })
    UserFollowersAndFollowingRequestModel toDsModel(UserFollowersAndFollowingDataMapper userFollowersAndFollowingDataMapper);
    
    @Mappings({
            @Mapping(target = "followed.id", source = "followedId"),
            @Mapping(target = "follower.id", source = "followerId"),
    })
    UserFollowersAndFollowingDataMapper toDataMapper(UserFollowersAndFollowingRequestModel userRelationshipRequestModel);
    
}
