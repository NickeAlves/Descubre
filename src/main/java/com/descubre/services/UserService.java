package com.descubre.services;

import com.descubre.dtos.LoginDTO;
import com.descubre.dtos.RegisterDTO;
import com.descubre.models.User;
import com.descubre.repositories.UserRepository;
import com.descubre.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User registerUser(RegisterDTO registerDTO) {
        Optional<User> existingUser = userRepository.findByEmail(registerDTO.email());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email is already in use.");
        }

        String encodedPassword = passwordEncoder.encode(registerDTO.password());
        User user = new User(registerDTO.name(), registerDTO.email(), encodedPassword, Set.of("ROLE_USER"));

        return userRepository.save(user);
    }

    public String loginUser(LoginDTO loginDTO) {
        Optional<User> userOptional = userRepository.findByEmail(loginDTO.email());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(loginDTO.password(), user.getPassword())) {
                return JWTUtil.generateToken(user.getEmail(), user.getRoles());
            }
        }
        throw new RuntimeException("Email or password incorrect.");
    }
}
