package kg.teksher.api.config;

import kg.teksher.api.entity.User;
import kg.teksher.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(UserRepository repository) {

        return args -> {

            if (repository.findByLogin("admin").isEmpty()) {

                User admin = new User(
                        "admin",
                        "admin123",
                        "Администратор",
                        "ADMIN"
                );

                repository.save(admin);

                System.out.println("====================================");
                System.out.println(" Администратор создан");
                System.out.println(" Логин: admin");
                System.out.println(" Пароль: admin123");
                System.out.println("====================================");

            }

        };
    }
}