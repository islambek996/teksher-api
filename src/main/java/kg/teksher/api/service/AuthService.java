package kg.teksher.api.service;

import kg.teksher.api.dto.LoginRequest;
import kg.teksher.api.dto.LoginResponse;
import kg.teksher.api.entity.User;
import kg.teksher.api.repository.UserRepository;
import kg.teksher.api.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public AuthService(UserRepository repository,
                       PasswordEncoder encoder,
                       JwtService jwtService) {

        this.repository = repository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {

        User user = repository.findByLogin(request.getLogin()).orElse(null);

        if (user == null) {
            return new LoginResponse(false, "Пользователь не найден", null);
        }

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            return new LoginResponse(false, "Неверный пароль", null);
        }

        String token = jwtService.generateToken(user.getLogin());

        return new LoginResponse(
                true,
                "Успешный вход",
                token
        );
    }
    private final JwtService jwtService;
}