package com.paymybuddy.proto.controller.security;

import com.paymybuddy.proto.configuration.security.TokenUtils;
import com.paymybuddy.proto.model.Account;
import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.model.roles.ERole;
import com.paymybuddy.proto.model.roles.Role;
import com.paymybuddy.proto.payload.request.LoginRequest;
import com.paymybuddy.proto.payload.request.SignupRequest;
import com.paymybuddy.proto.payload.response.MessageResponse;
import com.paymybuddy.proto.payload.response.TokenResponse;
import com.paymybuddy.proto.repository.AccountRepository;
import com.paymybuddy.proto.repository.security.RoleRepository;
import com.paymybuddy.proto.repository.security.ProfileRepository;
import com.paymybuddy.proto.service.TransactionService;
import com.paymybuddy.proto.service.security.UserDetailsImpl;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Configurable
@Slf4j
public class AuthController {

    static Logger logger = Logger.getLogger(AuthController.class.getName());
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    TokenUtils tokenUtils;

    @RequestMapping("/signin")
    public String displayHome() {
        return "login";
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new TokenResponse(token,
                userDetails.getId(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (profileRepository.existsByEmail(signUpRequest.getEmail())) {
           logger.config("Email is already exist !");
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already exist!");
        }

        profileRepository.register();
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
