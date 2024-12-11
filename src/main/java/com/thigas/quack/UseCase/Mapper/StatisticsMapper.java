package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.AddressDataMapper;
import com.thigas.quack.Adapter.Entity.StatisticsDataMapper;
import com.thigas.quack.Domain.Entity.Implementation.CommonStatistics;
import com.thigas.quack.Domain.Entity.Interface.Statistics;
import com.thigas.quack.Domain.Entity.Interface.User;
import com.thigas.quack.UseCase.Model.Request.AddressRequestModel;
import com.thigas.quack.UseCase.Model.Request.StatisticsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import com.thigas.quack.UseCase.Model.Response.StatisticsInfoResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {MapperDefaults.class})
public interface StatisticsMapper {

    StatisticsMapper MAPPER = Mappers.getMapper(StatisticsMapper.class);

    StatisticsRequestModel toDsModel(Statistics statistics);

    @Mapping(target = "user.id", source = "userId")
    StatisticsDataMapper toDataMapper(StatisticsRequestModel statisticsRequestModel);

    @Mapping(target = "userId", source = "user.id")
    StatisticsRequestModel toDsModel(StatisticsDataMapper statisticsDataMapper);

    @Mapping(target = "userId", source = "user.id")
    StatisticsInfoResponseModel toInfoDsModel(StatisticsDataMapper statisticsDataMapper);

    CommonStatistics toEntity(StatisticsRequestModel statisticsRequestModel);

    StatisticsRequestModel toDsModel(CommonStatistics statisticsDataMapper);

}