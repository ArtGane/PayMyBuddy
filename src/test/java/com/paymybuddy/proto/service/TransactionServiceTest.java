package com.paymybuddy.proto.service;

import com.paymybuddy.proto.model.Account;
import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.model.Transaction;
import com.paymybuddy.proto.model.TransactionType;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.AbstractDocument;
import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TransactionServiceTest extends Mockito {

    @Autowired
    public TransactionService transactionService;

    Account user = Mockito.mock(Account.class);
    Account friend = Mockito.mock(Account.class);


    @BeforeEach
    void init() {
        user.setBalance(100);
        friend.setBalance(150);
    }

    @Test
    void verifyAccountTest() {
        long amount = 12;
        Assert.assertTrue(transactionService.verifyAccount(user, (user.getBalance()) + amount));
    }

    @Test
    void transfer() {
        double amount = 14;
        double finalAmount = 164;
        transactionService.transfer(user, friend.getId(), amount);

        double balance = friend.getBalance();

        Assertions.assertEquals(balance, finalAmount);
    }

    @Test
    void deposit() {
        double amount = 14;
        transactionService.deposit(user, amount);

        Assert.assertEquals(user.getBalance(), amount);
    }

    @Test
    void withdrawal() {
        int amount = 14;
        transactionService.withdrawal(user, amount);

        Assert.assertEquals(user.getBalance(), amount);
    }
}