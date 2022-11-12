package com.paymybuddy.proto.controller;

import com.paymybuddy.proto.model.Account;
import com.paymybuddy.proto.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping()
    public Optional<Account> getAccount(@RequestParam int userId) {
        return accountService.getAccount(userId);
    }
}
