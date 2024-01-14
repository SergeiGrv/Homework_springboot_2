package ru.netology.homework_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.netology.homework_2.authorities.Authorities;
import ru.netology.homework_2.credentials.InvalidCredentials;
import ru.netology.homework_2.credentials.UnauthorizedUser;
import ru.netology.homework_2.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> credentialsException(InvalidCredentials e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> authorizationException(){
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
