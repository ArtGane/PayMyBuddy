package com.paymybuddy.proto.service;

import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.model.Transaction;
import com.paymybuddy.proto.model.TransactionType;
import com.paymybuddy.proto.repository.AccountRepository;
import com.paymybuddy.proto.repository.TransactionRepository;
import com.paymybuddy.proto.repository.security.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AccountRepository accountRepository;


    public List<Transaction> getAllTransactions(Profile profile) {
        return transactionRepository.findAll();
    }

//    public Transaction paidFriend(String email, int amount) {
//        Optional<Profile> profile = profileRepository.findByEmail(email);
//
//
//        // verifier solde du compte =! decouvert
//    }

//    public List<TransactionType> getOperations() { return transactionRepository.findAll(); }
}
