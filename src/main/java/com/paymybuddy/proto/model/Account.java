package com.paymybuddy.proto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="tb_accounts")
@Data
@Slf4j
public class Account {
    public Account(int id, LocalDateTime creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }
    public Account() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    private double balance;

    @ManyToMany
    private List<Transaction> transactions;

}
