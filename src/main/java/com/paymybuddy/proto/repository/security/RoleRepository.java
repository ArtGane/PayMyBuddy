package com.paymybuddy.proto.repository.security;

import com.paymybuddy.proto.model.roles.ERole;
import com.paymybuddy.proto.model.roles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
