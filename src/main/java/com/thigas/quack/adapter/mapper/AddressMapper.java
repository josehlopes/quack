package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "user.id", target = "userId")
    AddressDTO entityToDto(AddressEntity address);

    @Mapping(source = "userId", target = "user.id")
    AddressEntity dtoToEntity(AddressDTO addressDTO);

    @Mapping(source = "user.id", target = "user.id")
    AddressModel entityToModel(AddressEntity address);

    @Mapping(source = "user.id", target = "user.id")
    AddressEntity modelToEntity(AddressModel addressModel);

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
