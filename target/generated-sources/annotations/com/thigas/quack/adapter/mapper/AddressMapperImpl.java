package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-28T12:09:03-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDTO entityToDto(AddressEntity address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setUser( addressUserId( address ) );
        addressDTO.setCity( address.getCity() );
        addressDTO.setCountry( address.getCountry() );
        addressDTO.setId( address.getId() );
        addressDTO.setNumber( address.getNumber() );
        addressDTO.setState( address.getState() );
        addressDTO.setStreet( address.getStreet() );
        addressDTO.setZipCode( address.getZipCode() );

        return addressDTO;
    }

    @Override
    public AddressEntity dtoToEntity(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setUser( addressDTOToUserEntity( addressDTO ) );
        addressEntity.setCity( addressDTO.getCity() );
        addressEntity.setCountry( addressDTO.getCountry() );
        addressEntity.setId( addressDTO.getId() );
        addressEntity.setNumber( addressDTO.getNumber() );
        addressEntity.setState( addressDTO.getState() );
        addressEntity.setStreet( addressDTO.getStreet() );
        addressEntity.setZipCode( addressDTO.getZipCode() );

        return addressEntity;
    }

    @Override
    public AddressModel entityToModel(AddressEntity address) {
        if ( address == null ) {
            return null;
        }

        AddressModel addressModel = new AddressModel();

        addressModel.setUser( userEntityToUserModel( address.getUser() ) );
        addressModel.setCity( address.getCity() );
        addressModel.setCountry( address.getCountry() );
        addressModel.setId( address.getId() );
        addressModel.setNumber( address.getNumber() );
        addressModel.setState( address.getState() );
        addressModel.setStreet( address.getStreet() );
        addressModel.setZipCode( address.getZipCode() );

        return addressModel;
    }

    @Override
    public AddressEntity modelToEntity(AddressModel addressModel) {
        if ( addressModel == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setUser( userModelToUserEntity( addressModel.getUser() ) );
        addressEntity.setCity( addressModel.getCity() );
        addressEntity.setCountry( addressModel.getCountry() );
        addressEntity.setId( addressModel.getId() );
        addressEntity.setNumber( addressModel.getNumber() );
        addressEntity.setState( addressModel.getState() );
        addressEntity.setStreet( addressModel.getStreet() );
        addressEntity.setZipCode( addressModel.getZipCode() );

        return addressEntity;
    }

    @Override
    public AddressModel dtoToModel(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        AddressModel addressModel = new AddressModel();

        addressModel.setCity( addressDTO.getCity() );
        addressModel.setCountry( addressDTO.getCountry() );
        addressModel.setId( addressDTO.getId() );
        addressModel.setNumber( addressDTO.getNumber() );
        addressModel.setState( addressDTO.getState() );
        addressModel.setStreet( addressDTO.getStreet() );
        addressModel.setUser( map( addressDTO.getUser() ) );
        addressModel.setZipCode( addressDTO.getZipCode() );

        return addressModel;
    }

    @Override
    public AddressDTO modelToDto(AddressModel addressModel) {
        if ( addressModel == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCity( addressModel.getCity() );
        addressDTO.setCountry( addressModel.getCountry() );
        addressDTO.setId( addressModel.getId() );
        addressDTO.setNumber( addressModel.getNumber() );
        addressDTO.setState( addressModel.getState() );
        addressDTO.setStreet( addressModel.getStreet() );
        addressDTO.setUser( map( addressModel.getUser() ) );
        addressDTO.setZipCode( addressModel.getZipCode() );

        return addressDTO;
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

        userEntity.setId( addressDTO.getUser() );

        return userEntity;
    }

    protected UserModel userEntityToUserModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userEntity.getId() );
        userModel.setBornAt( userEntity.getBornAt() );
        userModel.setCpf( userEntity.getCpf() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setImagePath( userEntity.getImagePath() );
        userModel.setName( userEntity.getName() );
        userModel.setPassword( userEntity.getPassword() );
        userModel.setPhone( userEntity.getPhone() );
        userModel.setPoints( userEntity.getPoints() );
        userModel.setRegisterAt( userEntity.getRegisterAt() );
        userModel.setStatus( userEntity.getStatus() );
        userModel.setUsername( userEntity.getUsername() );

        return userModel;
    }

    protected UserEntity userModelToUserEntity(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userModel.getId() );
        userEntity.setBornAt( userModel.getBornAt() );
        userEntity.setCpf( userModel.getCpf() );
        userEntity.setEmail( userModel.getEmail() );
        userEntity.setImagePath( userModel.getImagePath() );
        userEntity.setName( userModel.getName() );
        userEntity.setPassword( userModel.getPassword() );
        userEntity.setPhone( userModel.getPhone() );
        userEntity.setPoints( userModel.getPoints() );
        userEntity.setRegisterAt( userModel.getRegisterAt() );
        userEntity.setStatus( userModel.getStatus() );
        userEntity.setUsername( userModel.getUsername() );

        return userEntity;
    }
}
