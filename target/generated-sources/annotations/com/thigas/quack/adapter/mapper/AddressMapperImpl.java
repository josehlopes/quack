package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Autowired
    private DefaultMapper defaultMapper;

    @Override
    public AddressEntity dtoToEntity(AddressDTO addressDTO, CycleAvoidingMappingContext context) {
        if ( addressDTO == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setUser( addressDTOToUserEntity( addressDTO, context ) );
        addressEntity.setStatus( defaultMapper.integerToStatusValue( addressDTO.getStatus() ) );
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
    public AddressDTO entityToDto(AddressEntity address, CycleAvoidingMappingContext context) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setUser( addressUserId( address ) );
        addressDTO.setStatus( defaultMapper.statusValueToInteger( address.getStatus() ) );
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
    public AddressModel entityToModel(AddressEntity address, CycleAvoidingMappingContext context) {
        if ( address == null ) {
            return null;
        }

        AddressModel addressModel = new AddressModel();

        addressModel.setId( address.getId() );
        addressModel.setUser( userEntityToUserModel( address.getUser(), context ) );
        addressModel.setStreet( address.getStreet() );
        addressModel.setCity( address.getCity() );
        addressModel.setState( address.getState() );
        addressModel.setCountry( address.getCountry() );
        addressModel.setZipCode( address.getZipCode() );
        addressModel.setNumber( address.getNumber() );
        addressModel.setStatus( address.getStatus() );

        return addressModel;
    }

    @Override
    public AddressEntity modelToEntity(AddressModel addressModel, CycleAvoidingMappingContext context) {
        if ( addressModel == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setId( addressModel.getId() );
        addressEntity.setUser( userModelToUserEntity( addressModel.getUser(), context ) );
        addressEntity.setStreet( addressModel.getStreet() );
        addressEntity.setCity( addressModel.getCity() );
        addressEntity.setState( addressModel.getState() );
        addressEntity.setCountry( addressModel.getCountry() );
        addressEntity.setZipCode( addressModel.getZipCode() );
        addressEntity.setNumber( addressModel.getNumber() );
        addressEntity.setStatus( addressModel.getStatus() );

        return addressEntity;
    }

    @Override
    public AddressModel dtoToModel(AddressDTO addressDTO, CycleAvoidingMappingContext context) {
        if ( addressDTO == null ) {
            return null;
        }

        AddressModel addressModel = new AddressModel();

        addressModel.setUser( addressDTOToUserModel( addressDTO, context ) );
        addressModel.setStatus( defaultMapper.integerToStatusValue( addressDTO.getStatus() ) );
        addressModel.setId( addressDTO.getId() );
        addressModel.setStreet( addressDTO.getStreet() );
        addressModel.setCity( addressDTO.getCity() );
        addressModel.setState( addressDTO.getState() );
        addressModel.setCountry( addressDTO.getCountry() );
        addressModel.setZipCode( addressDTO.getZipCode() );
        addressModel.setNumber( addressDTO.getNumber() );

        return addressModel;
    }

    @Override
    public AddressDTO modelToDto(AddressModel addressModel, CycleAvoidingMappingContext context) {
        if ( addressModel == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setUser( addressModelUserId( addressModel ) );
        addressDTO.setStatus( defaultMapper.statusValueToInteger( addressModel.getStatus() ) );
        addressDTO.setId( addressModel.getId() );
        addressDTO.setStreet( addressModel.getStreet() );
        addressDTO.setCity( addressModel.getCity() );
        addressDTO.setState( addressModel.getState() );
        addressDTO.setCountry( addressModel.getCountry() );
        addressDTO.setZipCode( addressModel.getZipCode() );
        addressDTO.setNumber( addressModel.getNumber() );

        return addressDTO;
    }

    protected UserEntity addressDTOToUserEntity(AddressDTO addressDTO, CycleAvoidingMappingContext context) {
        if ( addressDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( addressDTO.getUser() );

        return userEntity;
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

    protected UserModel userEntityToUserModel(UserEntity userEntity, CycleAvoidingMappingContext context) {
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

    protected UserEntity userModelToUserEntity(UserModel userModel, CycleAvoidingMappingContext context) {
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

    protected UserModel addressDTOToUserModel(AddressDTO addressDTO, CycleAvoidingMappingContext context) {
        if ( addressDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( addressDTO.getUser() );

        return userModel;
    }

    private int addressModelUserId(AddressModel addressModel) {
        if ( addressModel == null ) {
            return 0;
        }
        UserModel user = addressModel.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }
}
