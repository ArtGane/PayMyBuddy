package com.paymybuddy.proto.service;

import com.paymybuddy.proto.dto.FriendDTO;
import com.paymybuddy.proto.model.Account;
import com.paymybuddy.proto.model.Transaction;
import com.paymybuddy.proto.repository.AccountRepository;
import com.paymybuddy.proto.repository.TransactionRepository;
import com.paymybuddy.proto.repository.security.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AccountRepository accountRepository;


    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction paidFriend(String firstname, int amount) {
        List<FriendDTO> friends = profileRepository.getFriends();
        FriendDTO friend = (FriendDTO) friends.stream().filter(n -> n.getFirstname().equals(firstname));


        Account account = ;


        // verifier solde du compte =! decouvert
    }

    public List<Transaction> getOperations() { return transactionRepository.findAll(); }
}
