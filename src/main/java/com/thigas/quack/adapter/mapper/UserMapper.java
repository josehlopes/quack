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
    @Mapping(source = "userAchievements", target = "userAchievements")

    UserDTO entityToDto(UserEntity user);

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "status", target = "status", qualifiedByName = "userIntToStatus")
    @Mapping(source = "userAchievements", target = "userAchievements")

    UserEntity dtoToEntity(UserDTO userDTO);

    UserModel entityToModel(UserEntity userEntity);

    UserEntity modelToEntity(UserModel userModel);

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "status", target = "status", qualifiedByName = "userIntToStatus")
    @Mapping(source = "userAchievements", target = "userAchievements")

    UserModel dtoToModel(UserDTO userDTO);

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "status", target = "status", qualifiedByName = "userStatusToInt")
    @Mapping(source = "userAchievements", target = "userAchievements")

    UserDTO modelToDto(UserModel userModel);

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
    default int statusToInt(Status status) {
        return status != null ? status.getValue() : 0;
    }

    @Named("userIntToStatus")
    default Status intToStatus(int value) {
        return Status.fromValue(value);
    }

}
