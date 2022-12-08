package com.paymybuddy.proto.controller;

import com.paymybuddy.proto.model.Account;
import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.model.Transaction;
import com.paymybuddy.proto.repository.TransactionRepository;
import com.paymybuddy.proto.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/transfer")
@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping()
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/{friend_account_id}")
    public Transaction transfer(@RequestBody Account userAccount, @PathVariable int friendAccountId, @RequestParam double amount) {
        return transactionService.transfer(userAccount, friendAccountId, amount);
    }

    @GetMapping("/deposit")
    public Transaction deposit(@RequestBody Account account, @RequestParam int amount) {
        return transactionService.deposit(account, amount);
    }

    @GetMapping("/withdrawal")
    public Transaction withdrawal(@RequestBody Account account, @RequestParam int amount) {
        return transactionService.withdrawal(account, amount);
    }

    // void ?

}
