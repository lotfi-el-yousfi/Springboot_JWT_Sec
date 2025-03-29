package com.freshservice.jwtsec.controller;

import com.freshservice.jwtsec.dto.AuthRequest;
import com.freshservice.jwtsec.service.AuthService;
import com.freshservice.jwtsec.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping
    public ResponseEntity<String> addAuth(@RequestBody AuthRequest req) {
        String token = jwtUtil.generateToken(req.getUsername());
        return ResponseEntity.ok().
                body(token);
    }


}
