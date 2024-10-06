package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.OffsetDateTime;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "status", target = "status", qualifiedByName = "userStatusToInt")
    UserDTO entityToDto(UserEntity user);

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "status", target = "status", qualifiedByName = "userIntToStatus")
    UserEntity dtoToEntity(UserDTO userDTO);

    UserModel entityToModel(UserEntity userEntity);

    UserEntity modelToEntity(UserModel userModel);

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "status", target = "status", qualifiedByName = "userIntToStatus")
    UserModel dtoToModel(UserDTO userDTO);

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "status", target = "status", qualifiedByName = "userStatusToInt")
    UserDTO modelToDto(UserModel userModel);

    @Named("integerToUserModel")
    default UserModel integerToUserModel(Integer user) {
        if (user == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setId(user);
        return userModel;
    }

    @Named("userModelToInteger")
    default Integer userModelToInteger(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return userModel.getId();
    }

    @Named("integerToUserEntity")
    default UserEntity integerToUserEntity(Integer user) {
        if (user == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user);
        return userEntity;
    }

    @Named("userEntityToInteger")
    default Integer userEntityToInteger(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return userEntity.getId();
    }

    default OffsetDateTime offSetToString(String date) {
        if (date == null) {
            return null;
        }
        return OffsetDateTime.parse(date);
    }

    default String stringToOffSet(OffsetDateTime date) {
        if (date == null) {
            return null;
        }
        return date.toString();
    }

    @Named("userStatusToInt")
    default int userRoadmapMapStatusToInteger(Status status) {
        return MapperUtils.statusToInt(status);
    }

    @Named("userIntToStatus")
    default Status userRoadmapMapIntegerToStatus(int value) {
        return MapperUtils.intToStatus(value);
    }

}
