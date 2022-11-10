package com.paymybuddy.proto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_accounts")
@Data
public class Account {
    public Account(int id, LocalDateTime creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }
    public Account() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    private double balance;

    // Getters et setters //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
