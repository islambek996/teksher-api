package kg.teksher.api.controller;

import kg.teksher.api.dto.LoginRequest;
import kg.teksher.api.dto.LoginResponse;
import kg.teksher.api.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return service.login(request);
    }

}