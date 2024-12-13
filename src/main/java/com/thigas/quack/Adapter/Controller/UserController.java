package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.AddressInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserAchievementInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.ImageFileMapper;
import com.thigas.quack.UseCase.Model.Request.*;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    private final ImageFileMapper imageFileMapper;
    
    
    @GetMapping("/{id}")
    public ResponseEntity<UserRequestModel> getUserById(@PathVariable Integer id) {
            return userDsGateway.getUserById(id)
                    .map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<UserRequestModel>> getAllUsers() {
            Iterable<UserRequestModel> users = userDsGateway.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody UserRequestModel userDTO) {
        if (id.equals(userDTO.id())) {
            ResponseWrapper<GenericResponseModel> success = userInput.updateUser(userDTO);
            if (success.getStatusCode() == 204) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping(path = "/{id}/update-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  ResponseEntity<Void> updateProfileImage(@PathVariable Integer id, @RequestPart MultipartFile imageFile) {
        try {
            ProfileImageRequestModel convertedImage = imageFileMapper.toMultiPartModel(imageFile);
            ResponseWrapper<GenericResponseModel> response = userInput.saveProfileImage(id ,convertedImage);
            if (response.getStatusCode() == 200) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<Void> deactivateUser(@PathVariable Integer id) {
        try {
            ResponseWrapper<GenericResponseModel> response = userInput.deactivateUser(id);
            if (response.getStatusCode() == 200) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}