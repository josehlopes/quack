package com.thigas.quack.adapter.controller;

import com.thigas.quack.adapter.dto.LoginRequestDTO;
import com.thigas.quack.adapter.dto.RegisterRequestDTO;
import com.thigas.quack.adapter.dto.ResponseDTO;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.infrastructure.persistence.security.TokenService;
import lombok.RequiredArgsConstructor;
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
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        System.out.println("Attempting to log in with email: " + body.email());
        UserEntity user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        System.out.println("Register endpoint hit with email: " + body.email());
        Optional<UserEntity> user = this.userRepository.findByEmail(body.email());

        if(user.isEmpty()){
            UserEntity newUser = new UserEntity();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setId(body.id());
            newUser.setName(body.name());
            newUser.setCpf(body.cpf());
            newUser.setPhone(body.phone());
            newUser.setBornAt(body.bornAt());
            newUser.setRegisterAt(body.registerAt());
            newUser.setPoints(body.points());
            newUser.setImagePath(body.imagePath());

            this.userRepository.save(newUser);

                String token = this.tokenService.generateToken(newUser);
                return ResponseEntity.ok(new ResponseDTO(newUser.getEmail(), token));
            }
            return ResponseEntity.badRequest().build();
        }


    }

