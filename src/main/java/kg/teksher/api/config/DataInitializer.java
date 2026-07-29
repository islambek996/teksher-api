package kg.teksher.api.config;

import kg.teksher.api.entity.User;
import kg.teksher.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(UserRepository repository,
                           PasswordEncoder encoder) {

        return args -> {

            if (repository.findByLogin("admin").isEmpty()) {

                User admin = new User(
                        "admin",
                        encoder.encode("admin123"),
                        "Администратор",
                        "ADMIN"
                );

                repository.save(admin);

                System.out.println("Admin created");
            }

        };
    }
}