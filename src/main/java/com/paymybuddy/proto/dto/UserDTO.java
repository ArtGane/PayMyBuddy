package com.paymybuddy.proto.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends ModelDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private AccountDTO account;
    private List<FriendDTO> friends = new ArrayList<>();

}
