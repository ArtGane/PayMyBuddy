package com.paymybuddy.proto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_transaction")
@Data
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    private TransactionType transactionType;

    @ManyToOne
    private Profile profile;

    @Nullable
    @ManyToOne
    private Profile friend;

    public Transaction(double amount, TransactionType transactionType, Profile profile, Profile friend) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.profile = profile;
        this.friend = friend;
    }

    public Transaction(double amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }


    // Guetter et setters //

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getFriend() {
        return friend;
    }

    public void setFriend(Profile friend) {
        this.friend = friend;
    }

}
