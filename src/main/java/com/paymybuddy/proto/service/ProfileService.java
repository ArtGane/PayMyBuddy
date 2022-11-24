package com.paymybuddy.proto.service;

import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.repository.security.ProfileRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Optional<Profile> findByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    public Profile updateProfile(Profile profile) {
        return profileRepository.saveAndFlush(profile);
    }

    public void removeProfile(Profile profile) {
        profileRepository.delete(profile);
    }

}
