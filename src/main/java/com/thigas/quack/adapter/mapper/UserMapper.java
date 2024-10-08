package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.OffsetDateTime;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    UserDTO entityToDto(UserEntity user);

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    UserEntity dtoToEntity(UserDTO userDTO);

    UserModel entityToModel(UserEntity userEntity);

    UserEntity modelToEntity(UserModel userModel);

    default OffsetDateTime offSetToString(String date) {
        if (date == null) {
            return null;
        }
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
        return offsetDateTime;
    }

    default String stringToOffSet(OffsetDateTime date) {
        if (date == null) {
            return null;
        }
        String offsetDateTime = date.toString();
        return offsetDateTime;
    }
}
