package ru.netology.homework_2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.homework_2.authorities.Authorities;
import ru.netology.homework_2.repository.UserRepository;
import ru.netology.homework_2.service.AuthorizationService;


@Configuration
public class JavaConfig {

    @Bean
    public AuthorizationService service() {
        return new AuthorizationService();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public Authorities[] authorities(){
        return Authorities.values();
    }
}
