package com.paymybuddy.proto.service;

import com.paymybuddy.proto.model.Account;
import com.paymybuddy.proto.model.Profile;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {
    @Autowired
    AccountService accountService;

    @Test
    void getAccountTest() {
        Profile profile = new Profile();
        Account account = new Account();
        profile.setAccount(account);

        accountService.getAccount(2);
    }

    @Test
    void verifyBalanceAccount() {
    }
}