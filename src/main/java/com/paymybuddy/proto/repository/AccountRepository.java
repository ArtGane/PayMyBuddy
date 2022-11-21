package com.paymybuddy.proto.repository;

import com.paymybuddy.proto.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account getAccount(int id_user);

}
