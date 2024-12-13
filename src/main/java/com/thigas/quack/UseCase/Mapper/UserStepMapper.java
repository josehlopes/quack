package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.UserStepDataMapper;
import com.thigas.quack.Domain.Entity.Implementation.CommonUserStep;
import com.thigas.quack.Domain.Entity.Interface.UserStep;
import com.thigas.quack.UseCase.Model.Request.UserStepRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface UserStepMapper {

    UserStepMapper MAPPER = Mappers.getMapper(UserStepMapper.class);

    UserStepRequestModel toDsModel(UserStep userStep);

    @Mappings({
            @Mapping(target = "user.id", source = "userId"),
            @Mapping(target = "step.id", source = "stepId")
    })
    UserStepDataMapper toDataMapper(UserStepRequestModel userStepRequestModel);


    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "stepId", source = "step.id")
    })
    UserStepRequestModel toDsModel(UserStepDataMapper userStepDataMapper);

    CommonUserStep toEntity(UserStepRequestModel userStepRequestModel);
}
