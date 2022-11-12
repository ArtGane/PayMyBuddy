package com.paymybuddy.proto.service;

import com.paymybuddy.proto.configuration.SecurityConfig;
import com.paymybuddy.proto.dto.FriendDTO;
import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.repository.security.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
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

    public List<FriendDTO> addFriend(String email) {
        Optional<Profile> friendProfile = getProfile(email);
        FriendDTO friend = new FriendDTO(friendProfile.get().getFirstname(), email);

        List<FriendDTO> friends = profileRepository.getFriends();
        friends.add(friend);

        return friends;
    }
    public List<FriendDTO> getFriends() {
        return profileRepository.getFriends();
    }
}
