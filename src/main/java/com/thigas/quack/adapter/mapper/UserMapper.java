package com.thigas.quack.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Mapeia User para UserDTO
    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    UserDTO toUserDTO(UserEntity user);

    // Mapeia UserDTO para User
    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    UserEntity toUser(UserDTO userDTO);

    @Mapping(source = "bornAt", target = "bornAt")
    @Mapping(source = "registerAt", target = "registerAt")
    UserModel toUserModel(UserEntity userEntity);

    @Mapping(source = "bornAt", target = "bornAt")
    @Mapping(source = "registerAt", target = "registerAt")
    UserEntity toUser(UserModel userModel);
}
