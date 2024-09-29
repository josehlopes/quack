package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "status", target = "status")
    AddressEntity dtoToEntity(AddressDTO addressDTO);

    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "status", target = "status")
    AddressDTO entityToDto(AddressEntity address);

    AddressModel entityToModel(AddressEntity address);

    AddressEntity modelToEntity(AddressModel addressModel);

    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "status", target = "status")
    AddressModel dtoToModel(AddressDTO addressDTO);

    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "status", target = "status")
    AddressDTO modelToDto(AddressModel addressModel);

    default UserModel integerToUserModel(Integer user) {
        if (user == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setId(user);
        return userModel;
    }

    default Integer userModelIdToInteger(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return userModel.getId();
    }

    default int statusValueToAddressInteger(Status status) {
        return status != null ? status.getValue() : 0;
    }

    default Status addressIntegerToStatusValue(int value) {
        return Status.fromValue(value);
    }
}