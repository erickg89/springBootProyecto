package com.vidrieriasilice.proyecto.controller;

import com.vidrieriasilice.proyecto.dto.SignupUserDTO;
import com.vidrieriasilice.proyecto.dto.UserProfileDTO;
import com.vidrieriasilice.proyecto.exception.BadRequestException;
import com.vidrieriasilice.proyecto.model.User;
import com.vidrieriasilice.proyecto.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class AccountController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    UserProfileDTO signup(@RequestBody @Validated SignupUserDTO signupUserDTO) {
        boolean existsEmail = userRepository.existsByEmail(signupUserDTO.getEmail());

        if (existsEmail) {
            throw new BadRequestException("Email already exists.");
        }
        User user = new ModelMapper().map(signupUserDTO, User.class);
        user.setPassword(passwordEncoder.encode(signupUserDTO.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setRole(User.Role.USER);

        userRepository.save(user);

        return new ModelMapper().map(user, UserProfileDTO.class);
    }
}
