package com.paymybuddy.proto.service;

import com.paymybuddy.proto.model.Account;
import com.paymybuddy.proto.model.Transaction;
import com.paymybuddy.proto.model.TransactionType;
import com.paymybuddy.proto.repository.AccountRepository;
import com.paymybuddy.proto.repository.TransactionRepository;
import com.paymybuddy.proto.repository.security.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    static Logger logger = Logger.getLogger(TransactionService.class.getName());

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransfers() {
        List<Transaction> transactions = getAllTransactions();

        List<Transaction> transfers = transactions.stream()
                .filter(t -> t.getTransactionType().equals(TransactionType.TRANSFER))
                .collect(Collectors.toList());

        return transfers;
    }

    public List<Transaction> getOperations() {
        List<Transaction> transactions = getAllTransactions();

        List<Transaction> operations = transactions.stream()
                .filter(d -> d.getTransactionType().equals(TransactionType.DEPOSIT))
                .filter(w -> w.getTransactionType().equals(TransactionType.WITHDRAWAL))
                .collect(Collectors.toList());

        return operations;
    }

    public boolean verifyAccount(Account account, double amount) {
        if (account.getBalance() >= amount) {
            return true;
        } else {
            return false;
        }
    }

    public Transaction transfer(Account userAccount, int friendAccountId, double amount) {
        // body = compte existant mais id de ami ?
        Account friendAccount = accountRepository.getReferenceById(friendAccountId);

        if (verifyAccount(userAccount, amount)) {
            double userBalance = ((userAccount.getBalance()) - amount);
            userAccount.setBalance(userBalance);
            double friendBalance = ((friendAccount.getBalance()) + amount);
            friendAccount.setBalance(friendBalance);
        } else {
            logger.info("You can't make the transfer because your balance can't be in negative");
        }

        Transaction transfer = new Transaction(amount, TransactionType.TRANSFER);
        transactionRepository.saveAndFlush(transfer);

        return transfer;
    }

    public Transaction deposit(Account account, double amount) {
        double balance = (account.getBalance() + amount);
        account.setBalance(balance);

        Transaction deposit = new Transaction(amount, TransactionType.DEPOSIT);
        transactionRepository.saveAndFlush(deposit);
        accountRepository.saveAndFlush(account);

        logger.info("Depot make succesfully !");

        return deposit;
    }

    public Transaction withdrawal(Account account, double amount) {

        if (verifyAccount(account, amount)) {
            double balance = (account.getBalance() - amount);
            account.setBalance(balance);
        } else {
            logger.info("you can't make this withdrawal because your balance can't be in negative");
        }

        Transaction withdrawal = new Transaction(amount, TransactionType.WITHDRAWAL);
        transactionRepository.saveAndFlush(withdrawal);
        accountRepository.saveAndFlush(account);

        return withdrawal;
    }
}
