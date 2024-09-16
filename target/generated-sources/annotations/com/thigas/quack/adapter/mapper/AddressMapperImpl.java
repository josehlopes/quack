package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-16T15:11:41-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDTO EntityToDto(AddressEntity address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setUserId( addressUserId( address ) );
        addressDTO.setId( address.getId() );
        addressDTO.setStreet( address.getStreet() );
        addressDTO.setCity( address.getCity() );
        addressDTO.setState( address.getState() );
        addressDTO.setCountry( address.getCountry() );
        addressDTO.setZipCode( address.getZipCode() );
        addressDTO.setNumber( address.getNumber() );

        return addressDTO;
    }

    @Override
    public AddressEntity DtoToEntity(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setUser( addressDTOToUserEntity( addressDTO ) );
        addressEntity.setId( addressDTO.getId() );
        addressEntity.setStreet( addressDTO.getStreet() );
        addressEntity.setCity( addressDTO.getCity() );
        addressEntity.setState( addressDTO.getState() );
        addressEntity.setCountry( addressDTO.getCountry() );
        addressEntity.setZipCode( addressDTO.getZipCode() );
        addressEntity.setNumber( addressDTO.getNumber() );

        return addressEntity;
    }

    @Override
    public AddressModel EntityToModel(AddressEntity address) {
        if ( address == null ) {
            return null;
        }

        AddressModel addressModel = new AddressModel();

        addressModel.setUser( userEntityToUserModel( address.getUser() ) );
        addressModel.setId( address.getId() );
        addressModel.setStreet( address.getStreet() );
        addressModel.setCity( address.getCity() );
        addressModel.setState( address.getState() );
        addressModel.setCountry( address.getCountry() );
        addressModel.setZipCode( address.getZipCode() );
        addressModel.setNumber( address.getNumber() );

        return addressModel;
    }

    @Override
    public AddressEntity ModelToEntity(AddressModel addressModel) {
        if ( addressModel == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setUser( userModelToUserEntity( addressModel.getUser() ) );
        addressEntity.setId( addressModel.getId() );
        addressEntity.setStreet( addressModel.getStreet() );
        addressEntity.setCity( addressModel.getCity() );
        addressEntity.setState( addressModel.getState() );
        addressEntity.setCountry( addressModel.getCountry() );
        addressEntity.setZipCode( addressModel.getZipCode() );
        addressEntity.setNumber( addressModel.getNumber() );

        return addressEntity;
    }

    private int addressUserId(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return 0;
        }
        UserEntity user = addressEntity.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    protected UserEntity addressDTOToUserEntity(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( addressDTO.getUserId() );

        return userEntity;
    }

    protected UserModel userEntityToUserModel(UserEntity userEntity) {
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

    protected UserEntity userModelToUserEntity(UserModel userModel) {
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
