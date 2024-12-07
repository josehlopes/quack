package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Model.Request.UserLoginRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private final UserInputBoundary userInput;

    @PostMapping("users/login")
    public ResponseEntity<ResponseWrapper<GenericResponseModel>> login(@Valid @RequestBody UserLoginRequestModel loginBody) {
        ResponseWrapper<GenericResponseModel> response = userInput.login(loginBody);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("users/createAddress")
    public ResponseEntity<ResponseWrapper<GenericResponseModel>> register(@Valid @RequestBody UserRegisterRequestModel registerBody) {
        ResponseWrapper<GenericResponseModel> response = userInput.createUser(registerBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}