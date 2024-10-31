package com.vidrieriasilice.proyecto.controller;

import com.vidrieriasilice.proyecto.dto.AuthRequest;
import com.vidrieriasilice.proyecto.dto.AuthResponse;
import com.vidrieriasilice.proyecto.dto.UserProfileDTO;
import com.vidrieriasilice.proyecto.model.User;
import com.vidrieriasilice.proyecto.exception.ResourceNotFoundException;
import com.vidrieriasilice.proyecto.repository.UserRepository;
import com.vidrieriasilice.proyecto.security.jwt.TokenProvider;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class JWTController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserRepository userRepository;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        );
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        User user = userRepository
                .findByEmail(authRequest.getEmail())
                .orElseThrow(ResourceNotFoundException::new);

        UserProfileDTO userProfileDTO = new ModelMapper().map(user, UserProfileDTO.class);
        AuthResponse authResponse = new AuthResponse(token, userProfileDTO);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(authResponse);
    }
}
