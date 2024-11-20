package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.AddressDataMapper;
import com.thigas.quack.Domain.Entity.Address;
import com.thigas.quack.UseCase.Model.Request.Address.AddressDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressMapper MAPPER = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "user.id", source = "userId")
    AddressDataMapper toDataMapper(AddressDsDtoRequestModel addressDsDtoRequestModel);

    AddressDsDtoRequestModel toDsModel(AddressDataMapper addressDataMapper);

    AddressInfoDtoResponseModel toInfoDto(AddressDataMapper addressDataMapper);

    AddressDsDtoRequestModel toDsModel(Address address);
}
