package com.paymybuddy.proto.controller;

import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.model.Transaction;
import com.paymybuddy.proto.repository.TransactionRepository;
import com.paymybuddy.proto.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/transactions")
@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping()
    public List<Transaction> getAllTransactions(@RequestParam Profile profile) {
        return transactionService.getAllTransactions(profile);
    }

    @PostMapping
    public Transaction payFriend(@RequestParam String email, @RequestParam int amount) {
        return transactionService.paidFriend();
    }
}
