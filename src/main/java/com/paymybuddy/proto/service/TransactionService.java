package com.paymybuddy.proto.service;

import com.paymybuddy.proto.dto.FriendDTO;
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

    public Transaction transfer(String firstname, int amount) {
        List<Transaction> transactions = transactionRepository.getAllTransactions(profileRepository);

        List<FriendDTO> friends = profileRepository.getFriends();
        FriendDTO friend = (FriendDTO) friends.stream().filter(n -> n.getFirstname().equals(firstname));

        Account userAccount = accountRepository.getAccount(profileRepository.getId());
        Account friendAccount = friend.getAccount(friend.getId());

        if (userAccount.verifyAccount(amount) == true) {
            double userBalance = ((userAccount.getBalance()) - amount); 
            userAccount.setBalance(userBalance);
            double friendBalance = ((friendAccount.getBalance()) + amount);
            friend.setBalance(friendBalance);
        } else {
            logger.info("You can't make the transfer because your balance can't be in negative");
        }

        Transaction transfer = new Transaction(new int, new LocalDateTime(), TransactionType.TRANSFER);
        transactions.add(transfer);

        return transfer;
    }

    public Transaction deposit(int amount) {
        List<Transaction> transactions = transactionRepository.getAllTransactions(profileRepository);

        Account account = accountRepository.getAccount(profileRepository.getId());
        double balance = (account.getBalance() + amount);
        account.setBalance(balance);

        Transaction deposit = new Transaction();
        transactions.add(deposit);

        logger.info("Depot make succesfully !");
        return deposit;
    }

    public Transaction withdrawal(int amount) {
        List<Transaction> transactions = transactionRepository.getAllTransactions(profileRepository);

        Account account = accountRepository.getAccount(profileRepository.getId());
    if (account.verifyAccount == true) {
        double balance =  (account.getBalance() - amount);
        account.setBalance(balance);
    } else {
        logger.info("you can't make this withdrawal because your balance can't be in negative");
    }

    Transaction withdrawal = new Transaction();
    transactions.add(withdrawal);

    return withdrawal;
    }

    public List<Transaction> getOperations() { return transactionRepository.findAll(); }
}
