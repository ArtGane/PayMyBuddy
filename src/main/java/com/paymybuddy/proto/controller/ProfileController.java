package com.paymybuddy.proto.controller;

import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.repository.security.ProfileRepository;
import com.paymybuddy.proto.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RequestMapping("/api/profile")
@RestController
@Slf4j
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @PutMapping("/update") // Refait un id à chaque fois si pas rentré pour les tests
    public Optional<Profile> updateProfile(@RequestBody Profile profile) {
        return profileRepository.updateProfile(profile);
    }

    @GetMapping()
    public Optional<Profile> getProfile(@RequestParam String email) {
        return profileRepository.findByEmail(email);
    }

    @GetMapping("/{user_id}/addConnection")
    public List<Profile> addFriend(@PathVariable long user_id, @RequestParam String email) {
        Optional<Profile> user = profileRepository.findById(user_id);
        Optional<Profile> friend = profileRepository.findByEmail(email);

        if (user.isPresent() && friend.isPresent()) {
            user.get().addFriend(friend.get());
            profileRepository.saveAndFlush(user.get());
        } else {
            log.error("");
        }

        return user.get().getFriends();
    }
}
