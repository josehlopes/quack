package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Model.Request.User.UserLoginDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.User.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.User.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.User.UserRegisterDtoResponseModel;
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
    public ResponseEntity<UserLoginDtoResponseModel> login(@Valid @RequestBody UserLoginDtoRequestModel loginBody) {
        UserLoginDtoResponseModel response = userInput.login(loginBody);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("users/register")
    public ResponseEntity<UserRegisterDtoResponseModel> register(@Valid @RequestBody UserRegisterDtoRequestModel registerBody) {
        UserRegisterDtoResponseModel response = userInput.register(registerBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}