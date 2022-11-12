package com.paymybuddy.proto.dto;

import com.paymybuddy.proto.model.Profile;

public class FriendDTO extends Profile {

    private String firstName;
    private String email;

    public FriendDTO(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }
}
