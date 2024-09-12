package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:10:37-0300",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDTO toAddressDTO(AddressEntity address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setUserId( addressUserId( address ) );
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
    public AddressEntity toAddress(AddressDTO addressDTO) {
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
    public AddressModel toAddressModel(AddressEntity address) {
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
    public AddressEntity toAddress(AddressModel addressModel) {
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

    private Long addressUserId(AddressEntity addressEntity) {
        UserEntity user = addressEntity.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
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
        userModel.setBornAt( userEntity.getBornAt() );
        userModel.setCpf( userEntity.getCpf() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setImagePath( userEntity.getImagePath() );
        userModel.setName( userEntity.getName() );
        userModel.setPassword( userEntity.getPassword() );
        userModel.setPhone( userEntity.getPhone() );
        userModel.setPoints( userEntity.getPoints() );
        userModel.setRegisterAt( userEntity.getRegisterAt() );

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

        return userEntity;
    }
}
