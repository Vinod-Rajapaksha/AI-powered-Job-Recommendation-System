package com.jobrecommendation.controller;

import com.jobrecommendation.dto.LoginDto;
import com.jobrecommendation.model.User;
import com.jobrecommendation.service.UserService;
import com.jobrecommendation.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );
        User user = userService.findByUsername(loginDto.getUsername());
        return jwtUtil.generateToken(user.getUsername());
    }
}