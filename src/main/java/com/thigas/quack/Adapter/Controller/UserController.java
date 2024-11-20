package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.AddressInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.Address.AddressCreateDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.Address.AddressDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.User.UserDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserInputBoundary userInput;
    private final UserDsGateway userDsGateway;
    private final AddressDsGateway addressDsGateway;
    private final AddressInputBoundary addressInput;

    @GetMapping("/{id}")
    public ResponseEntity<UserDsDtoRequestModel> getById(@PathVariable Integer id) {
        try {
            return userDsGateway.getById(id)
                    .map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<UserDsDtoRequestModel>> getAll() {
        try {
            Iterable<UserDsDtoRequestModel> users = userDsGateway.getAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UserDsDtoRequestModel userDTO) {
        try {
            if (id.equals(userDTO.id())) {
                Boolean success = userInput.update(userDTO);
                if (success) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                } else {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            Boolean success = userInput.delete(id);
            if (success) {
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

    @PostMapping("/address/create")
    public ResponseEntity<Void> createAddress(@RequestBody AddressCreateDtoRequestModel address) {
        try {
            Boolean success = addressInput.create(address);
            if (success) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/address/{userId}")
    public ResponseEntity<AddressInfoDtoResponseModel> getAddressByUserId(@PathVariable Integer userId, @RequestParam Integer addressId) {
        try {
            return addressDsGateway.getUserAddress(userId, addressId)
                    .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/address/getAll/{userId}")
    public ResponseEntity<Iterable<AddressInfoDtoResponseModel>> getAllAddresses(@PathVariable Integer userId) {
        try {
            Iterable<AddressInfoDtoResponseModel> addresses = addressDsGateway.getAllUserAddresses(userId);
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/address/update/{id}")
    public ResponseEntity<Void> updateAddress(@PathVariable Integer id, @RequestBody AddressDsDtoRequestModel address) {
        try {
            if (!id.equals(address.id())) {
                throw new IllegalArgumentException("Address id does not match");
            }

            Boolean success = addressInput.update(address);
            if (success) {
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

    @DeleteMapping("/address/delete/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        try {
            Boolean success = addressInput.delete(id);
            if (success) {
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