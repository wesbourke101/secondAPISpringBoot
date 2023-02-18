package com.in28minutes.springboot.myFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {

        boolean isValidUserName = username.equalsIgnoreCase("Wes");
        boolean isValidPassword = password.equalsIgnoreCase("Dummy");

        return isValidUserName && isValidPassword;
    }
}
