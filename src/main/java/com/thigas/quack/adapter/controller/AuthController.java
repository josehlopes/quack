package com.thigas.quack.adapter.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thigas.quack.adapter.dto.LoginRequestDTO;
import com.thigas.quack.adapter.dto.RegisterRequestDTO;
import com.thigas.quack.adapter.dto.ResponseDTO;
import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.application.service.UserService;
import com.thigas.quack.infrastructure.security.TokenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        System.out.println("Attempting to log in with email: " + body.email());
        UserDTO user = this.userService.findByEmail(body.email())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        System.out.println("Register endpoint hit with email: " + body.email());
        Optional<UserDTO> user = this.userService.findByEmail(body.email());

        if (user.isEmpty()) {
            UserDTO newUser = new UserDTO();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setId(body.id());
            newUser.setName(body.name());
            newUser.setUsername(body.username());
            newUser.setCpf(body.cpf());
            newUser.setPhone(body.phone());
            newUser.setBornAt(String.valueOf(body.bornAt()));
            newUser.setRegisterAt(String.valueOf(body.registerAt()));
            newUser.setPoints(body.points());
            newUser.setImagePath(body.imagePath());

            this.userService.create(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }

}
