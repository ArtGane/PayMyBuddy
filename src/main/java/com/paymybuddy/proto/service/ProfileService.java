package com.paymybuddy.proto.service;

import com.paymybuddy.proto.model.Account;
import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.model.roles.ERole;
import com.paymybuddy.proto.model.roles.Role;
import com.paymybuddy.proto.payload.request.SignupRequest;
import com.paymybuddy.proto.repository.AccountRepository;
import com.paymybuddy.proto.repository.security.ProfileRepository;

import com.paymybuddy.proto.repository.security.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
@Transactional
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    public Optional<Profile> findByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    public Profile updateProfile(Profile profile) {
        return profileRepository.saveAndFlush(profile);
    }

    public void removeProfile(Profile profile) {
        profileRepository.delete(profile);
    }

    // -----------------------------------------------Register---------------------------------------------------------- //

    public Profile register(SignupRequest signUpRequest) {
        // Create new user's profile
        Profile profile = new Profile(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        // Create new account's user
        Account account = new Account();
        account.setCreationDate(LocalDateTime.now());
        account.setBalance(0);
        account.setTransactions(new ArrayList<>());

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
        return profile;
    }

}
