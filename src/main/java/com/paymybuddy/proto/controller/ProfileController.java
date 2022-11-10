package com.paymybuddy.proto.controller;

import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/profile")
@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PutMapping("/") // Refait un id à chaque fois
    public Profile updateProfile(@RequestBody Profile profile) {
        return profileService.updateProfile(profile);
    }

    @GetMapping()
    public Optional<Profile> getProfile(@RequestParam String email) {
        return profileService.getProfile(email);
    }

    @PostMapping("/addConnection")
    public List<Profile> addFriend(@RequestParam String email) {
        return profileService.addFriend(email);
    }
}
