package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface AddressMapper {

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "status", target = "status", qualifiedByName = "integerToStatusValue")})
    AddressEntity dtoToEntity(AddressDTO addressDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "status", target = "status", qualifiedByName = "statusValueToInteger")})
    AddressDTO entityToDto(AddressEntity address, @Context CycleAvoidingMappingContext context);

    AddressModel entityToModel(AddressEntity address, @Context CycleAvoidingMappingContext context);

    AddressEntity modelToEntity(AddressModel addressModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "status", target = "status", qualifiedByName = "integerToStatusValue")})
    AddressModel dtoToModel(AddressDTO addressDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "status", target = "status", qualifiedByName = "statusValueToInteger")})
    AddressDTO modelToDto(AddressModel addressModel, @Context CycleAvoidingMappingContext context);

}