package com.thigas.quack.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "user.id", target = "userId")
    AddressDTO toAddressDTO(AddressEntity address);

    @Mapping(source = "userId", target = "user.id")
    AddressEntity toAddress(AddressDTO addressDTO);

    AddressModel toAddressModel(AddressEntity address);

    AddressEntity toAddress(AddressModel addressModel);

    default UserModel map(Integer userId) {
        if (userId == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setId(userId);
        return userModel;
    }

    default Integer map(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return userModel.getId();
    }

}
