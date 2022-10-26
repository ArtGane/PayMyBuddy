package com.paymybuddy.proto.controller.security;

import com.paymybuddy.proto.model.roles.ERole;
import com.paymybuddy.proto.payload.request.SignupRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerTest {

    @Test
    void authenticateUserTest() {
    }

    @Test
    void registerUserTest() {
        SignupRequest signup = new SignupRequest();
        signup.setLastname("Michel");
        signup.setEmail("michel@michel.com");
        signup.setPassword("abc12345678");
        signup.setRole(Collections.singleton("user"));
        AuthController auth = new AuthController();
        auth.registerUser(signup);
    }
}