package com.paymybuddy.proto.controller;

import com.paymybuddy.proto.dto.FriendDTO;
import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/profile")
@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

//    @GetMapping("/friend")
//    public FriendDTO getFriend(@RequestBody String email) {
//        FriendDTO friend = profileService.getFriend(email);
//        return friend;
//    }
//
//    @PostMapping
//    public List<FriendDTO> addFriend(@RequestBody String firstname, )
}
