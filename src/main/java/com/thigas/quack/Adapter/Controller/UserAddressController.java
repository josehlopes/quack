package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.AddressInputBoundary;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Model.Request.AddressCreateRequestModel;
import com.thigas.quack.UseCase.Model.Request.AddressRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users/address")
@AllArgsConstructor
public class UserAddressController {

    private final AddressInputBoundary addressInput;
    private final AddressDsGateway addressDsGateway;

    @PostMapping("/createAddress")
    public ResponseEntity<Void> createAddress(@RequestBody AddressCreateRequestModel address) {
        try {
            ResponseWrapper<GenericResponseModel> success = addressInput.createAddress(address);
            if (success.getStatusCode() == 201) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<AddressInfoResponseModel> getAddressByUserId(@PathVariable Integer userId, @RequestParam Integer addressId) {
        try {
            return addressDsGateway.getUserAddress(userId, addressId)
                    .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllAchievements/{userId}")
    public ResponseEntity<Iterable<AddressInfoResponseModel>> getAllAddresses(@PathVariable Integer userId) {
        try {
            Iterable<AddressInfoResponseModel> addresses = addressDsGateway.getAllUserAddresses(userId);
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateUserRoadmap/{id}")
    public ResponseEntity<Void> updateAddress(@PathVariable Integer id, @RequestBody AddressRequestModel address) {
        try {
            if (!id.equals(address.id())) {
                throw new IllegalArgumentException("Address id does not matchPassword");
            }

            ResponseWrapper<GenericResponseModel> success = addressInput.updateAddress(address);
            if (success.getStatusCode() == 204) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        try {
            ResponseWrapper<GenericResponseModel> success = addressInput.delete(id);
            if (success.getStatusCode() == 204) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
