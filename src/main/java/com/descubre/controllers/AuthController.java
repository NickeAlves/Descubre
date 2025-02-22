package com.descubre.controllers;

import com.descubre.dtos.LoginDTO;
import com.descubre.dtos.RegisterDTO;
import com.descubre.dtos.ResponseDTO;
import com.descubre.models.User;
import com.descubre.repositories.UserRepository;
import com.descubre.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final TokenService tokenService;

    @Autowired
    public AuthController(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@Valid @RequestBody RegisterDTO body) {
        if (userRepository.findByEmail(body.email()).isPresent()) {
            return ResponseEntity.status(400).body(new ResponseDTO("Email already registered", null, null));
        }
        User newUser = new User();
        newUser.setName(body.name());
        newUser.setEmail(body.email());
        newUser.setPassword(passwordEncoder.encode(body.password()));

        userRepository.save(newUser);

        String token = tokenService.generateToken(newUser);

        return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token, newUser.getId().toString()));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO body) {
        Optional<User> optionalUser = userRepository.findByEmail(body.email());

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(404).body(new ResponseDTO("User not found", null, null));
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(body.password(), user.getPassword())) {
            return ResponseEntity.status(401).body(new ResponseDTO("Invalid credentials", null, null));
        }

        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new ResponseDTO(user.getName(), token, user.getId().toString()));
    }

    @PostMapping("/logout")
    public ResponseEntity<ResponseDTO> logout (@RequestHeader(name = "Authorization", required = false) String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(400).body(new ResponseDTO("Invalid token format", null, null));
        }
        String authToken = token.substring(7);
        return ResponseEntity.ok(new ResponseDTO("Logged out successfully", null, null));
    }

}
