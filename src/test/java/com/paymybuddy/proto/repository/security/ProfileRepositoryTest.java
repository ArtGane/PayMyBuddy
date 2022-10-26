package com.paymybuddy.proto.repository.security;

import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.service.ProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ProfileRepositoryTest {

    // ##########################REPARER AUTOWIRED CASSE########################## //

    @Test
    void findByEmailTest() {
        Profile profile = new Profile();
        profile.setEmail("blabla@bla.fr");
        ProfileService profileService = new ProfileService();
        profileService.getProfile("blala@bla.fr");
    }

    @Test
    void existsByEmailTest() {
    }
}