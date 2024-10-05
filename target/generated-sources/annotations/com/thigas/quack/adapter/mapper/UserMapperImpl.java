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
    date = "2024-10-05T18:22:49-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
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
        userDTO.setStatus( statusToInt( user.getStatus() ) );
        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPhone( user.getPhone() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setCpf( user.getCpf() );
        userDTO.setPoints( user.getPoints() );
        userDTO.setImagePath( user.getImagePath() );

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
        userEntity.setStatus( intToStatus( userDTO.getStatus() ) );
        userEntity.setId( userDTO.getId() );
        userEntity.setName( userDTO.getName() );
        userEntity.setUsername( userDTO.getUsername() );
        userEntity.setPhone( userDTO.getPhone() );
        userEntity.setEmail( userDTO.getEmail() );
        userEntity.setPassword( userDTO.getPassword() );
        userEntity.setCpf( userDTO.getCpf() );
        userEntity.setPoints( userDTO.getPoints() );
        userEntity.setImagePath( userDTO.getImagePath() );

        return userEntity;
    }

    @Override
    public UserModel entityToModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userEntity.getId() );
        userModel.setName( userEntity.getName() );
        userModel.setUsername( userEntity.getUsername() );
        userModel.setPhone( userEntity.getPhone() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setPassword( userEntity.getPassword() );
        userModel.setCpf( userEntity.getCpf() );
        userModel.setBornAt( userEntity.getBornAt() );
        userModel.setPoints( userEntity.getPoints() );
        userModel.setRegisterAt( userEntity.getRegisterAt() );
        userModel.setStatus( userEntity.getStatus() );
        userModel.setImagePath( userEntity.getImagePath() );

        return userModel;
    }

    @Override
    public UserEntity modelToEntity(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userModel.getId() );
        userEntity.setName( userModel.getName() );
        userEntity.setUsername( userModel.getUsername() );
        userEntity.setPhone( userModel.getPhone() );
        userEntity.setEmail( userModel.getEmail() );
        userEntity.setPassword( userModel.getPassword() );
        userEntity.setCpf( userModel.getCpf() );
        userEntity.setBornAt( userModel.getBornAt() );
        userEntity.setPoints( userModel.getPoints() );
        userEntity.setRegisterAt( userModel.getRegisterAt() );
        userEntity.setImagePath( userModel.getImagePath() );
        userEntity.setStatus( userModel.getStatus() );

        return userEntity;
    }

    @Override
    public UserModel dtoToModel(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        if ( userDTO.getBornAt() != null ) {
            userModel.setBornAt( LocalDate.parse( userDTO.getBornAt(), dateTimeFormatter_yyyy_MM_dd_0159776256 ) );
        }
        userModel.setRegisterAt( offSetToString( userDTO.getRegisterAt() ) );
        userModel.setStatus( intToStatus( userDTO.getStatus() ) );
        userModel.setId( userDTO.getId() );
        userModel.setName( userDTO.getName() );
        userModel.setUsername( userDTO.getUsername() );
        userModel.setPhone( userDTO.getPhone() );
        userModel.setEmail( userDTO.getEmail() );
        userModel.setPassword( userDTO.getPassword() );
        userModel.setCpf( userDTO.getCpf() );
        userModel.setPoints( userDTO.getPoints() );
        userModel.setImagePath( userDTO.getImagePath() );

        return userModel;
    }

    @Override
    public UserDTO modelToDto(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( userModel.getBornAt() != null ) {
            userDTO.setBornAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( userModel.getBornAt() ) );
        }
        userDTO.setRegisterAt( stringToOffSet( userModel.getRegisterAt() ) );
        userDTO.setStatus( statusToInt( userModel.getStatus() ) );
        userDTO.setId( userModel.getId() );
        userDTO.setName( userModel.getName() );
        userDTO.setUsername( userModel.getUsername() );
        userDTO.setPhone( userModel.getPhone() );
        userDTO.setEmail( userModel.getEmail() );
        userDTO.setPassword( userModel.getPassword() );
        userDTO.setCpf( userModel.getCpf() );
        userDTO.setPoints( userModel.getPoints() );
        userDTO.setImagePath( userModel.getImagePath() );

        return userDTO;
    }
}
