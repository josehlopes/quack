package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.AddressInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserAchievementInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.*;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserInputBoundary userInput;
    private final UserDsGateway userDsGateway;
    private final AddressDsGateway addressDsGateway;
    private final AddressInputBoundary addressInput;
    private final UserAchievementDsGateway userAchievementDsGateway;
    private final UserAchievementInputBoundary userAchievementInput;

    @GetMapping("/{id}")
    public ResponseEntity<UserRequestModel> getById(@PathVariable Integer id) {
        try {
            return userDsGateway.getById(id)
                    .map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<UserRequestModel>> getAll() {
        try {
            Iterable<UserRequestModel> users = userDsGateway.getAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UserRequestModel userDTO) {
        try {
            if (id.equals(userDTO.id())) {
                ResponseWrapper<GenericResponseModel> success = userInput.update(userDTO);
                if (success.getStatusCode() == 204) {
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
            ResponseWrapper<GenericResponseModel> success = userInput.delete(id);
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

    @PostMapping("/address/create")
    public ResponseEntity<Void> createAddress(@RequestBody AddressCreateRequestModel address) {
        try {
            ResponseWrapper<GenericResponseModel> success = addressInput.create(address);
            if (success.getStatusCode() == 201) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/address/{userId}")
    public ResponseEntity<AddressInfoResponseModel> getAddressByUserId(@PathVariable Integer userId, @RequestParam Integer addressId) {
        try {
            return addressDsGateway.getUserAddress(userId, addressId)
                    .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/address/getAll/{userId}")
    public ResponseEntity<Iterable<AddressInfoResponseModel>> getAllAddresses(@PathVariable Integer userId) {
        try {
            Iterable<AddressInfoResponseModel> addresses = addressDsGateway.getAllUserAddresses(userId);
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/address/update/{id}")
    public ResponseEntity<Void> updateAddress(@PathVariable Integer id, @RequestBody AddressRequestModel address) {
        try {
            if (!id.equals(address.id())) {
                throw new IllegalArgumentException("Address id does not match");
            }

            ResponseWrapper<GenericResponseModel> success = addressInput.update(address);
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

    @DeleteMapping("/address/delete/{id}")
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

    @PostMapping("/achievement/create")
    public ResponseEntity<Void> createAchievement(@RequestBody UserAchievementUnlockRequestModel request) {
        try {
            ResponseWrapper<GenericResponseModel> success = userAchievementInput.unlockUserAchievement(request);
            if (success.getStatusCode() == 201) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/achievement/{userId}")
//    public ResponseEntity<AddressInfoResponseModel> getAddressByUserId(@PathVariable Integer userId, @RequestParam Integer addressId) {
//        try {
//            return addressDsGateway.getUserAddress(userId, addressId)
//                    .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
//                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//        } catch (Exception ex) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
    @GetMapping("/achievement/getAll/{userId}")
    public ResponseEntity<Iterable<AchievementRequestModel>> getAllUserAchievements(@PathVariable Integer userId) {
        try {
            Iterable<AchievementRequestModel> achievements = userAchievementDsGateway.getAllUserAchievements(userId);
            return new ResponseEntity<>(achievements, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}