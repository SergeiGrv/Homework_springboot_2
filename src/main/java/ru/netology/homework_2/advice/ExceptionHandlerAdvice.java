package ru.netology.homework_2.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.homework_2.credentials.InvalidCredentials;
import ru.netology.homework_2.credentials.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> credentialsException(InvalidCredentials e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> authorizationException(UnauthorizedUser e){
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
