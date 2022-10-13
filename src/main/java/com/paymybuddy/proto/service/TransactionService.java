package com.paymybuddy.proto.service;

import com.paymybuddy.proto.model.TransactionEntity;
import com.paymybuddy.proto.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionEntity> getTransactions() {
        return transactionRepository.findAll();
    }
}