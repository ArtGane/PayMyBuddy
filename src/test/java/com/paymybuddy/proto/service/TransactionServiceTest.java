//package com.paymybuddy.proto.service;
//
//import com.paymybuddy.proto.model.Account;
//import com.paymybuddy.proto.model.Profile;
//import com.paymybuddy.proto.model.Transaction;
//import com.paymybuddy.proto.model.TransactionType;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.validation.constraints.AssertTrue;
//
//@SpringBootTest
//class TransactionServiceTest {
//
//    @Autowired
//    public TransactionService transactionService;
//
//    @Test
//    void getTransactionsTest() {
//    }
//
//    @Test
//    void verifyAccountTest() {
//        Account account = new Account();
//        account.setBalance(54.13);
//
//        int amount = 12;
//        Assert.assertTrue(transactionService.verifyAccount(amount));
//    }
//
//    @Test
//    void transfer() {
//        Account myAccount = new Account();
//        myAccount.setBalance(54.13);
//        double amount = 14;
//
//        Profile friend = new Profile();
//        Account accountFriend = friend.getAccount();
//        accountFriend.setBalance(0.0);
//        friend.setFirstname("Jean-Eudes");
//
//        transactionService.transfer(friend.getFirstname(), amount);
//
//        Assert.assertEquals(friend.getAccount(), amount);
//    }
//
//    @Test
//    void deposit() {
//        Account myAccount = new Account();
//        myAccount.setBalance(40.13);
//        double amount = 14;
//
//        transactionService.deposit(amount);
//
//        Assert.assertEquals(myAccount.getBalance(), amount);
//    }
//
//    @Test
//    void withdrawal() {
//        Account myAccount = new Account();
//        myAccount.setBalance(54.13);
//        int amount = 14;
//
//        transactionService.withdrawal(amount);
//
//        Assert.assertEquals(myAccount.getBalance(), amount);
//    }
//}