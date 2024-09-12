package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.domain.entity.User;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T01:01:59-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_T_HH_mm_ss_11798231098 = DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss" );

    @Override
    public UserDTO toUserDTO(User user) {
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
    public User toUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        if ( userDTO.getBornAt() != null ) {
            user.setBornAt( LocalDate.parse( userDTO.getBornAt(), dateTimeFormatter_yyyy_MM_dd_0159776256 ) );
        }
        if ( userDTO.getRegisterAt() != null ) {
            user.setRegisterAt( LocalDateTime.parse( userDTO.getRegisterAt(), dateTimeFormatter_yyyy_MM_dd_T_HH_mm_ss_11798231098 ) );
        }
        user.setId( userDTO.getId() );
        user.setName( userDTO.getName() );
        user.setPhone( userDTO.getPhone() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );
        user.setCpf( userDTO.getCpf() );
        user.setPoints( userDTO.getPoints() );
        user.setImagePath( userDTO.getImagePath() );

        return user;
    }

    @Override
    public UserModel toUserModel(User user) {
        if ( user == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( user.getId() );
        userModel.setName( user.getName() );
        userModel.setPhone( user.getPhone() );
        userModel.setEmail( user.getEmail() );
        userModel.setPassword( user.getPassword() );
        userModel.setCpf( user.getCpf() );
        userModel.setBornAt( user.getBornAt() );
        userModel.setPoints( user.getPoints() );
        userModel.setRegisterAt( user.getRegisterAt() );
        userModel.setImagePath( user.getImagePath() );

        return userModel;
    }

    @Override
    public User toUser(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        User user = new User();

        user.setId( userModel.getId() );
        user.setName( userModel.getName() );
        user.setPhone( userModel.getPhone() );
        user.setEmail( userModel.getEmail() );
        user.setPassword( userModel.getPassword() );
        user.setCpf( userModel.getCpf() );
        user.setBornAt( userModel.getBornAt() );
        user.setPoints( userModel.getPoints() );
        user.setRegisterAt( userModel.getRegisterAt() );
        user.setImagePath( userModel.getImagePath() );

        return user;
    }
}
