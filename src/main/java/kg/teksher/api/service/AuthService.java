package kg.teksher.api.service;

import kg.teksher.api.dto.LoginRequest;
import kg.teksher.api.dto.LoginResponse;
import kg.teksher.api.entity.User;
import kg.teksher.api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repository;

    public AuthService(UserRepository repository) {
        this.repository = repository;
    }

    public LoginResponse login(LoginRequest request) {

        User user = repository.findByLogin(request.getLogin()).orElse(null);

        if (user == null) {
            return new LoginResponse(false, "Пользователь не найден");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return new LoginResponse(false, "Неверный пароль");
        }

        return new LoginResponse(true, "Успешный вход");
    }

}