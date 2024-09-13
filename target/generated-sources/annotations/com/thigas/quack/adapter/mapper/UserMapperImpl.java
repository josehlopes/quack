package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-13T00:51:02-0300",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_T_HH_mm_ss_11798231098 = DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss" );

    @Override
    public UserDTO toUserDTO(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( user.getBornAt() != null ) {
            userDTO.setBornAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( user.getBornAt() ) );
        }
        if ( user.getRegisterAt() != null ) {
            userDTO.setRegisterAt( dateTimeFormatter_yyyy_MM_dd_T_HH_mm_ss_11798231098.format( user.getRegisterAt() ) );
        }
        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setPhone( user.getPhone() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setCpf( user.getCpf() );
        userDTO.setPoints( user.getPoints() );
        userDTO.setImagePath( user.getImagePath() );

        return userDTO;
    }

    @Override
    public UserEntity toUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        if ( userDTO.getBornAt() != null ) {
            userEntity.setBornAt( LocalDate.parse( userDTO.getBornAt(), dateTimeFormatter_yyyy_MM_dd_0159776256 ) );
        }
        if ( userDTO.getRegisterAt() != null ) {
            userEntity.setRegisterAt( LocalDateTime.parse( userDTO.getRegisterAt(), dateTimeFormatter_yyyy_MM_dd_T_HH_mm_ss_11798231098 ) );
        }
        userEntity.setId( userDTO.getId() );
        userEntity.setName( userDTO.getName() );
        userEntity.setPhone( userDTO.getPhone() );
        userEntity.setEmail( userDTO.getEmail() );
        userEntity.setPassword( userDTO.getPassword() );
        userEntity.setCpf( userDTO.getCpf() );
        userEntity.setPoints( userDTO.getPoints() );
        userEntity.setImagePath( userDTO.getImagePath() );

        return userEntity;
    }

    @Override
    public UserModel toUserModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userEntity.getId() );
        userModel.setName( userEntity.getName() );
        userModel.setPhone( userEntity.getPhone() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setPassword( userEntity.getPassword() );
        userModel.setCpf( userEntity.getCpf() );
        userModel.setBornAt( userEntity.getBornAt() );
        userModel.setPoints( userEntity.getPoints() );
        userModel.setRegisterAt( userEntity.getRegisterAt() );
        userModel.setImagePath( userEntity.getImagePath() );

        return userModel;
    }

    @Override
    public UserEntity toUser(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userModel.getId() );
        userEntity.setName( userModel.getName() );
        userEntity.setPhone( userModel.getPhone() );
        userEntity.setEmail( userModel.getEmail() );
        userEntity.setPassword( userModel.getPassword() );
        userEntity.setCpf( userModel.getCpf() );
        userEntity.setBornAt( userModel.getBornAt() );
        userEntity.setPoints( userModel.getPoints() );
        userEntity.setRegisterAt( userModel.getRegisterAt() );
        userEntity.setImagePath( userModel.getImagePath() );

        return userEntity;
    }
}
