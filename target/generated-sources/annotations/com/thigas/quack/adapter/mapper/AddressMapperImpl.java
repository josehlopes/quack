package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.Address;
import com.thigas.quack.domain.entity.User;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-11T15:39:14-0300",
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
    public Address toAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setUser( addressDTOToUser( addressDTO ) );
        address.setId( addressDTO.getId() );
        address.setStreet( addressDTO.getStreet() );
        address.setCity( addressDTO.getCity() );
        address.setState( addressDTO.getState() );
        address.setCountry( addressDTO.getCountry() );
        address.setZipCode( addressDTO.getZipCode() );
        address.setNumber( addressDTO.getNumber() );

        return address;
    }

    @Override
    public AddressModel toAddressModel(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressModel addressModel = new AddressModel();

        addressModel.setUser( userToUserModel( address.getUser() ) );
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
    public Address toAddress(AddressModel addressModel) {
        if ( addressModel == null ) {
            return null;
        }

        Address address = new Address();

        address.setUser( userModelToUser( addressModel.getUser() ) );
        address.setId( addressModel.getId() );
        address.setStreet( addressModel.getStreet() );
        address.setCity( addressModel.getCity() );
        address.setState( addressModel.getState() );
        address.setCountry( addressModel.getCountry() );
        address.setZipCode( addressModel.getZipCode() );
        address.setNumber( addressModel.getNumber() );

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

    protected User userModelToUser(UserModel userModel) {
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
