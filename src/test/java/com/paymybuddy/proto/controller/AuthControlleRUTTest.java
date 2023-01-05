package com.paymybuddy.proto.controller;

import com.paymybuddy.proto.controller.security.AuthController;
import com.paymybuddy.proto.payload.request.SignupRequest;
import com.paymybuddy.proto.repository.security.ProfileRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControlleRUTTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private ProfileRepository profileRepository;


    @DisplayName("registerUser - should return email Already Exist")
    @Test
    void registerUserSHouldReturnBadRequestAlreadyExist() {
        //GIVEN
        SignupRequest request = new SignupRequest();
        request.setEmail("toto");
        when(profileRepository.existsByEmail(anyString())).thenReturn(true);
        //WHEN
        ResponseEntity<?> result = authController.registerUser(request);
        //THEN
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertEquals("Error: Email is already exist!", result.getBody());
    }
}
