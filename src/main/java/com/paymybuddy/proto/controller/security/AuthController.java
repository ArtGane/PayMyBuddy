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
import com.paymybuddy.proto.service.security.UserDetailsImpl;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Configurable
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenUtils tokenUtils;

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
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already exist!"));
        }

        if (profileRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's profile
        Profile profile = new Profile(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        // Create new account's user
        Account account = new Account();
        account.setCreationDate(LocalDateTime.now());
        account.setBalance(0);

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        // Create empty list of friends for add it later
        List<Profile> friends = new ArrayList<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Any role was found "));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role admin is not found."));
                        roles.add(adminRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role user is not found"));
                        roles.add(userRole);
                }
            });
        }

        accountRepository.save(account);

        profile.setLastname(signUpRequest.getLastname());
        profile.setFirstname(signUpRequest.getFirstname());
        profile.setFriends(friends);
        profile.setAccount(account);
        profile.setRoles(roles);
        profile.setCreationDate(LocalDateTime.now());

        profileRepository.save(profile);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
