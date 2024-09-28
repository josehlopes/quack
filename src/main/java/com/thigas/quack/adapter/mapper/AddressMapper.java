package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "user.id", target = "user")
    AddressDTO entityToDto(AddressEntity address);

    @Mapping(source = "user", target = "user.id")
    AddressEntity dtoToEntity(AddressDTO addressDTO);

    @Mapping(source = "user.id", target = "user.id")
    AddressModel entityToModel(AddressEntity address);

    @Mapping(source = "user.id", target = "user.id")
    AddressEntity modelToEntity(AddressModel addressModel);

    default UserModel map(Integer user) {
        if (user == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setId(user);
        return userModel;
    }

    default Integer map(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return userModel.getId();
    }

    default Status map(int value) {
        return Status.fromValue(value);
    }

    // Mapeia de Status para int
    default int map(Status status) {
        return status.getValue();
    }
}
