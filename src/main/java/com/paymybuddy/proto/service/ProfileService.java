package com.paymybuddy.proto.service;

import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.repository.security.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;


    public Optional<Profile> getProfile(String email) {
        return profileRepository.findByEmail(email);
    }

    public Profile updateProfile(Profile profile) {
        return profileRepository.saveAndFlush(profile);
    }

    public void removeProfile(Profile profile) {
        profileRepository.delete(profile);
    }

    public List<Profile> addFriend(String email) {
        Optional<Profile> profile = getProfile(email);
        List<Profile> friends = profile.get().getFriends();
        return friends;
    }

}
