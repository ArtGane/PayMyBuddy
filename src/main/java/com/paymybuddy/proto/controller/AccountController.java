package com.paymybuddy.proto.controller;

import com.paymybuddy.proto.model.Account;
import com.paymybuddy.proto.repository.AccountRepository;
import com.paymybuddy.proto.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api/account")
@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/{user_id}")
    public Optional<Account> getAccount(@PathVariable int user_id) {
        return accountRepository.findById(user_id);
    }


}
