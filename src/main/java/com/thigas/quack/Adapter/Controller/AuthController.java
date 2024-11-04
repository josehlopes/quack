package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.Adapter.Dto.*;
import com.thigas.quack.UseCase.Model.Request.UserDsRequestModel;
import com.thigas.quack.UseCase.Service.UserService;
import com.thigas.quack.Infrastructure.Security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO loginBody) {

        Optional<UserDsRequestModel> userOptional = this.userService.findByEmail(loginBody.getEmail())
                .or(() -> this.userService.findByUsername(loginBody.getUsername()));

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorDTO("Usuário não encontrado", HttpStatus.NOT_FOUND.value()));
        }

        UserDsRequestModel user = userOptional.get();
        if (!passwordEncoder.matches(loginBody.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorDTO("Credenciais inválidas", HttpStatus.UNAUTHORIZED.value()));
        }

        String token = this.tokenService.generateToken(user.getEmail());
        return ResponseEntity.ok(new ResponseDTO(user.getEmail(), token));
    }



    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDTO registerBody) {
        Optional<UserDsRequestModel> user = this.userService.findByEmail(registerBody.getEmail());

        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ErrorDTO("E-mail já cadastrado", HttpStatus.CONFLICT.value()));
        }

        this.userService.create(registerBody);
        String token = this.tokenService.generateToken(registerBody.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO(registerBody.getEmail(), token));
    }


}
