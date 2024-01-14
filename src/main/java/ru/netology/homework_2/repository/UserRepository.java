package ru.netology.homework_2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.homework_2.authorities.Authorities;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    @Autowired
    Authorities[] authorities;

    public List<Authorities> getUserAuthorities(String user, String password) {

        List<Authorities> emptyAccess = new ArrayList<>();

        if (user.equals("test") || password.equals("test")){
            return List.of(authorities);
        }

        return emptyAccess;
    }
}