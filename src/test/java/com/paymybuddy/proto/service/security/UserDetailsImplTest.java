package com.paymybuddy.proto.service.security;

import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.model.roles.ERole;
import com.paymybuddy.proto.model.roles.Role;
import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDetailsImplTest extends Mockito {

    @Autowired
    UserDetailsImpl userDetails;

    Profile profile = Mockito.mock(Profile.class);

    @Before
    void build() {
        profile.setRoles((Set<Role>) new Role(ERole.ROLE_USER));
        profile.setFirstname("Beauty");
        profile.setLastname("Jelly");
        profile.setEmail("jellyfish@gmer.fr");
        profile.setPassword("notsecurepassword");
        userDetails.build(profile);
    }

    @Test
    void isAccountNonExpired() {
        userDetails.isAccountNonExpired();
    }

    @Test
    void isAccountNonLocked() {
        userDetails.isAccountNonLocked();
    }

    @Test
    void isCredentialsNonExpired() {
        userDetails.isCredentialsNonExpired();
    }

    @Test
    void isEnabled() {
        userDetails.isEnabled();
    }

    @Test
    void testEquals() {
        userDetails.equals(profile);
    }
}