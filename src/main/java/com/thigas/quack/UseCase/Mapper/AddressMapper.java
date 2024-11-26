package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.AddressDataMapper;
import com.thigas.quack.Domain.Entity.Interface.Address;
import com.thigas.quack.UseCase.Model.Request.AddressDsRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressMapper MAPPER = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "user.id", source = "userId")
    AddressDataMapper toDataMapper(AddressDsRequestModel addressDsRequestModel);

    AddressDsRequestModel toDsModel(AddressDataMapper addressDataMapper);

    AddressInfoResponseModel toInfoDto(AddressDataMapper addressDataMapper);

    AddressDsRequestModel toDsModel(Address address);
}
