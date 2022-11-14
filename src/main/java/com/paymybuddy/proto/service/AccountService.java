package com.paymybuddy.proto.service;

import com.paymybuddy.proto.model.Account;
import com.paymybuddy.proto.repository.AccountRepository;
import com.paymybuddy.proto.repository.security.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public Optional<Account> getAccount(int id_user) {
        return accountRepository.findById(id_user);
    }

}
