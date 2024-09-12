package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.domain.entity.User;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Mapeia User para UserDTO
    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    UserDTO toUserDTO(User user);

    // Mapeia UserDTO para User
    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    User toUser(UserDTO userDTO);

    // Mapeia User para UserModel
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "bornAt", target = "bornAt")
    @Mapping(source = "points", target = "points")
    @Mapping(source = "registerAt", target = "registerAt")
    @Mapping(source = "imagePath", target = "imagePath")
    UserModel toUserModel(User user);

    // Mapeia UserModel para User
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "bornAt", target = "bornAt")
    @Mapping(source = "points", target = "points")
    @Mapping(source = "registerAt", target = "registerAt")
    @Mapping(source = "imagePath", target = "imagePath")
    User toUser(UserModel userModel);
}