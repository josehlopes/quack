package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Mapper.ImageFileMapper;
import com.thigas.quack.UseCase.Model.Request.ProfileImageRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    
    private final UserInputBoundary userInput;
    private final ImageFileMapper imageFileMapper;
    
    @PostMapping("users/login")
    public ResponseEntity<ResponseWrapper<GenericResponseModel>> login(@RequestBody UserLoginRequestModel loginBody) {
        ResponseWrapper<GenericResponseModel> response = userInput.login(loginBody);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @PostMapping(value = "users/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseWrapper<GenericResponseModel>> register(@RequestBody UserRegisterRequestModel userJson, Model model,
                                                                          @RequestPart(name = "imageFile") MultipartFile file) {
        model.addAttribute("user", userJson);
        ProfileImageRequestModel profileImage = imageFileMapper.toMultiPartModel(file);
        ResponseWrapper<GenericResponseModel> response = userInput.createUser(userJson, profileImage);
        HttpStatus status = HttpStatus.valueOf(response.getStatusCode());
        return ResponseEntity.status(status).body(response);
    }
}