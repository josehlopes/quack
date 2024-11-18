package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.AddressInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.AddressCreateDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.AddressDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return userDsGateway.getById(id).map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<UserDsDtoRequestModel>> getAll() {
        Iterable<UserDsDtoRequestModel> users = userDsGateway.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UserDsDtoRequestModel userDTO) {
        if (id.equals(userDTO.id())) {
            userInput.update(userDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userInput.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/address/create")
    public ResponseEntity<Void> createAddress(@RequestBody AddressCreateDtoRequestModel address) {
        addressInput.create(address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/address/{userId}")
    public ResponseEntity<AddressInfoDtoResponseModel> getAddressByUserId(@PathVariable Integer userId) {
        return addressDsGateway.getByUserId(userId)
                .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/address")
    public ResponseEntity<Iterable<AddressInfoDtoResponseModel>> getAllAddresses(@PathVariable Integer userId) {
        Iterable<AddressInfoDtoResponseModel> addresses = addressDsGateway.getAllUserAddresses(userId);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<Void> updateAddress(@PathVariable Integer id, @RequestBody AddressDsDtoRequestModel address) {
        if (id.equals(address.id())) {
            addressInput.update(address);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        addressInput.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//
//    @PostMapping("/start-roadmap")
//    public ResponseEntity<Void> startRoadmap(@RequestBody UserRoadmapDtoRequestModel userRoadmapDTO) {
//        try {
//            if (userRoadmapService.startRoadmap(userRoadmapDTO.userId(), userRoadmapDTO.roadmapId())) {
//                return new ResponseEntity<>(HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @PutMapping("/end-roadmap/{id}")
//    public ResponseEntity<Void> endRoadmap(@PathVariable Integer id) {
//        try {
//            if (id == 0) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//            if (userRoadmapService.endRoadmap(id)) {
//                return new ResponseEntity<>(HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}

