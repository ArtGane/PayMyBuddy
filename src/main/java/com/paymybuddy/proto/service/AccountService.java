package com.paymybuddy.proto.service;

import com.paymybuddy.proto.model.AccountEntity;
import com.paymybuddy.proto.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<AccountEntity> getAccount(int id_user) {
        return accountRepository.findById(id_user);
    }
}
