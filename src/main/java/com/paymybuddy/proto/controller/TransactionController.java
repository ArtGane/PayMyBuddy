package com.paymybuddy.proto.controller;

import com.paymybuddy.proto.model.Account;
import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.model.Transaction;
import com.paymybuddy.proto.repository.TransactionRepository;
import com.paymybuddy.proto.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/profile/{user_id}/transfer")
@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping()
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{friend_account_id}")
    public Transaction transfer(@RequestBody Account user_account_id, @PathVariable int friend_account_id, @RequestParam double amount) {
        return transactionService.transfer(user_account_id, friend_account_id, amount);
    }

    @GetMapping("/deposit")
    public Transaction deposit(@RequestBody Account account, @RequestParam int amount) {
        return transactionService.deposit(account, amount);
    }

    @GetMapping("/withdrawal")
    public Transaction wihdrawal(@RequestBody Account account, @RequestParam int amount) {
        return transactionService.withdrawal(account, amount);
    }
}
