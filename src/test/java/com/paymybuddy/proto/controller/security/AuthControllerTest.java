package com.paymybuddy.proto.controller.security;

import com.paymybuddy.proto.model.roles.ERole;
import com.paymybuddy.proto.payload.request.SignupRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthControllerTest {

    @Autowired
    public AuthController auth;

    @Test
    void authenticateUserTest() {
    }

    @Test
    void registerUserTest() {
    }
}