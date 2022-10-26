package com.paymybuddy.proto.service;

import com.paymybuddy.proto.dto.FriendDTO;
import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.repository.security.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Optional<Profile> getProfile(String email) {
        return profileRepository.findByEmail(email);
    }

    public Profile createOrUpdateProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public void removeProfile(Profile profile) {
        profileRepository.delete(profile);
    }

}
