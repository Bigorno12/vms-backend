package com.pacdesign.rest.controller;

import com.pacdesign.service.AuthService;
import com.pacdesign.service.dto.PersonDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public Map<String, Object> registerHandler(@RequestBody PersonDto personDto) {
        return authService.registerHandler(personDto);
    }

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody PersonDto personDto) {
        return authService.loginHandler(personDto);
    }
}
