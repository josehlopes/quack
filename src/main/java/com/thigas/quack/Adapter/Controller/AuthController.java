package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.Infrastructure.Security.TokenService;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.ErrorDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("users/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDtoRequestModel loginBody) {

        Optional<UserDtoRequestModel> userOptional = this.userService.findByEmail(loginBody.email())
                .or(() -> this.userService.findByUsername(loginBody.username()));

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorDtoResponseModel("Usuário não encontrado", HttpStatus.NOT_FOUND.value()));
        }

        UserDtoRequestModel user = userOptional.get();
        if (!passwordEncoder.matches(loginBody.password(), user.password())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorDtoResponseModel("Credenciais inválidas", HttpStatus.UNAUTHORIZED.value()));
        }

        String token = this.tokenService.generateToken(user.email());
        return ResponseEntity.ok(new UserLoginDtoResponseModel(user.email(), LocalDate.now().toString(), token));
    }


    @PostMapping("users/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDtoRequestModel registerBody) {
//        Optional<UserDtoRequestModel> user = this.userService.findByEmail(registerBody.email());
//
//        if (user.isPresent()) {
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                    .body(new ErrorDtoResponseModel("E-mail já cadastrado", HttpStatus.CONFLICT.value()));
//        }

        this.userService.create(registerBody);
        String token = this.tokenService.generateToken(registerBody.email());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new UserLoginDtoResponseModel(registerBody.email(), LocalDate.now().toString(), token));
    }


}
