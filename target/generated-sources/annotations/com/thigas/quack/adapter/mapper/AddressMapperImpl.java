package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.Address;
import com.thigas.quack.domain.entity.User;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T10:55:40-0300",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDTO toAddressDTO(Address address) {
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
    public Address toAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setUser( addressDTOToUser( addressDTO ) );
        address.setCity( addressDTO.getCity() );
        address.setCountry( addressDTO.getCountry() );
        address.setId( addressDTO.getId() );
        address.setNumber( addressDTO.getNumber() );
        address.setState( addressDTO.getState() );
        address.setStreet( addressDTO.getStreet() );
        address.setZipCode( addressDTO.getZipCode() );

        return address;
    }

    @Override
    public AddressModel toAddressModel(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressModel addressModel = new AddressModel();

        addressModel.setUser( userToUserModel( address.getUser() ) );
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
    public Address toAddress(AddressModel addressModel) {
        if ( addressModel == null ) {
            return null;
        }

        Address address = new Address();

        address.setUser( userModelToUser( addressModel.getUser() ) );
        address.setCity( addressModel.getCity() );
        address.setCountry( addressModel.getCountry() );
        address.setId( addressModel.getId() );
        address.setNumber( addressModel.getNumber() );
        address.setState( addressModel.getState() );
        address.setStreet( addressModel.getStreet() );
        address.setZipCode( addressModel.getZipCode() );

        return address;
    }

    private Long addressUserId(Address address) {
        User user = address.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    protected User addressDTOToUser(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( addressDTO.getUserId() );

        return user;
    }

    protected UserModel userToUserModel(User user) {
        if ( user == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( user.getId() );
        userModel.setBornAt( user.getBornAt() );
        userModel.setCpf( user.getCpf() );
        userModel.setEmail( user.getEmail() );
        userModel.setImagePath( user.getImagePath() );
        userModel.setName( user.getName() );
        userModel.setPassword( user.getPassword() );
        userModel.setPhone( user.getPhone() );
        userModel.setPoints( user.getPoints() );
        userModel.setRegisterAt( user.getRegisterAt() );

        return userModel;
    }

    protected User userModelToUser(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        User user = new User();

        user.setId( userModel.getId() );
        user.setBornAt( userModel.getBornAt() );
        user.setCpf( userModel.getCpf() );
        user.setEmail( userModel.getEmail() );
        user.setImagePath( userModel.getImagePath() );
        user.setName( userModel.getName() );
        user.setPassword( userModel.getPassword() );
        user.setPhone( userModel.getPhone() );
        user.setPoints( userModel.getPoints() );
        user.setRegisterAt( userModel.getRegisterAt() );

        return user;
    }
}
