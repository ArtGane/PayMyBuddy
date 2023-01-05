package com.paymybuddy.proto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_transactions")
@Data
@NoArgsConstructor
@Slf4j
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    private TransactionType transactionType;

    @ManyToOne
    private Account account;

    @Nullable
    @ManyToOne
    private Account friend;

    public Transaction(double amount, TransactionType transactionType, Account profile, Account friend) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.account = profile;
        this.friend = friend;
    }

    public Transaction(double amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }

}