package com.paymybuddy.proto.repository;

import com.paymybuddy.proto.model.Profile;
import com.paymybuddy.proto.model.Transaction;
import com.paymybuddy.proto.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> getAllTransactions(Profile profile);

    Transaction paidFriend(String email, int amount);

    //List<Enum.EnumDesc> getAllTransfers(List<Transaction> transactions);
}
