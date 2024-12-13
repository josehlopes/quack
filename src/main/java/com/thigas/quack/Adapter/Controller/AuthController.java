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
    
    @PostMapping("users/login")
    public ResponseEntity<ResponseWrapper<GenericResponseModel>> login(@RequestBody UserLoginRequestModel loginBody) {
        ResponseWrapper<GenericResponseModel> response = userInput.login(loginBody);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @PostMapping("users/register")
    public ResponseEntity<ResponseWrapper<GenericResponseModel>> register(@RequestBody UserRegisterRequestModel registerBody) {
        ResponseWrapper<GenericResponseModel> response = userInput.createUser(registerBody);
        HttpStatus status = HttpStatus.valueOf(response.getStatusCode());
        return ResponseEntity.status(status).body(response);
    }
}