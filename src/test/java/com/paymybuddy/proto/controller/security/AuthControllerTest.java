package com.paymybuddy.proto.controller.security;


import com.paymybuddy.proto.service.security.UserDetailsImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = AuthController.class)
class AuthControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserDetailsImpl userDetails;

    @Test
    void authenticateUserTest() throws Exception {
        mockMvc.perform(post("/signin")).andExpect(status().isOk());
    }

    @Test
    void registerUserTest() throws Exception {
        mockMvc.perform(post("/signup")).andExpect(status().isOk());
    }
}