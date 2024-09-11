package com.thigas.quack.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.Address;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "user.id", target = "userId")
    AddressDTO toAddressDTO(Address address);

    @Mapping(source = "userId", target = "user.id")
    Address toAddress(AddressDTO addressDTO);

    @Mapping(source = "user.id", target = "user.id")
    AddressModel toAddressModel(Address address);

    @Mapping(source = "user.id", target = "user.id")
    Address toAddress(AddressModel addressModel);

    // Métodos de mapeamento personalizados
    default UserModel map(Long userId) {
        if (userId == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setId(userId);
        return userModel;
    }

    default Long map(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return userModel.getId();
    }

}
