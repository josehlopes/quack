package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.AddressDataMapper;
import com.thigas.quack.Domain.Entity.Address;
import com.thigas.quack.UseCase.Model.Request.AddressDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressMapper MAPPER = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "userId", target = "user.id")
    AddressDataMapper toDataMapper(AddressDsDtoRequestModel addressDsDtoRequestModel);

    AddressDsDtoRequestModel toDsModel(AddressDataMapper addressDataMapper);

    AddressInfoDtoResponseModel toInfoDto(AddressDataMapper addressDataMapper);

    @Mapping(source = "address.user.id", target = "userId")
    AddressDsDtoRequestModel toDsModel(Address address, Integer userId);
}
