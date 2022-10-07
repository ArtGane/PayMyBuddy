package com.paymybuddy.proto.repository;

import com.paymybuddy.proto.model.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
}
