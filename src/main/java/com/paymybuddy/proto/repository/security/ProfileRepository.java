package com.paymybuddy.proto.repository.security;

import com.paymybuddy.proto.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByEmail(String email);
    boolean existsByEmail(String email);

}
