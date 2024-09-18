package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-18T14:27:49-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    @Override
    public UserDTO entityToDto(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( user.getBornAt() != null ) {
            userDTO.setBornAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( user.getBornAt() ) );
        }
        userDTO.setRegisterAt( stringToOffSet( user.getRegisterAt() ) );
        userDTO.setCpf( user.getCpf() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setId( user.getId() );
        userDTO.setImagePath( user.getImagePath() );
        userDTO.setName( user.getName() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setPhone( user.getPhone() );
        userDTO.setPoints( user.getPoints() );

        return userDTO;
    }

    @Override
    public UserEntity dtoToEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        if ( userDTO.getBornAt() != null ) {
            userEntity.setBornAt( LocalDate.parse( userDTO.getBornAt(), dateTimeFormatter_yyyy_MM_dd_0159776256 ) );
        }
        userEntity.setRegisterAt( offSetToString( userDTO.getRegisterAt() ) );
        userEntity.setCpf( userDTO.getCpf() );
        userEntity.setEmail( userDTO.getEmail() );
        userEntity.setId( userDTO.getId() );
        userEntity.setImagePath( userDTO.getImagePath() );
        userEntity.setName( userDTO.getName() );
        userEntity.setPassword( userDTO.getPassword() );
        userEntity.setPhone( userDTO.getPhone() );
        userEntity.setPoints( userDTO.getPoints() );

        return userEntity;
    }

    @Override
    public UserModel entityToModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setBornAt( userEntity.getBornAt() );
        userModel.setCpf( userEntity.getCpf() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setId( userEntity.getId() );
        userModel.setImagePath( userEntity.getImagePath() );
        userModel.setName( userEntity.getName() );
        userModel.setPassword( userEntity.getPassword() );
        userModel.setPhone( userEntity.getPhone() );
        userModel.setPoints( userEntity.getPoints() );
        userModel.setRegisterAt( userEntity.getRegisterAt() );

        return userModel;
    }

    @Override
    public UserEntity modelToEntity(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setBornAt( userModel.getBornAt() );
        userEntity.setCpf( userModel.getCpf() );
        userEntity.setEmail( userModel.getEmail() );
        userEntity.setId( userModel.getId() );
        userEntity.setImagePath( userModel.getImagePath() );
        userEntity.setName( userModel.getName() );
        userEntity.setPassword( userModel.getPassword() );
        userEntity.setPhone( userModel.getPhone() );
        userEntity.setPoints( userModel.getPoints() );
        userEntity.setRegisterAt( userModel.getRegisterAt() );

        return userEntity;
    }
}
