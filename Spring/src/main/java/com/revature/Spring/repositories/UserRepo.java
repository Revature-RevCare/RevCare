package com.revature.Spring.repositories;

import com.revature.Spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByLast(String last);

    Optional<User> findByEmail(String email);
    Boolean existsByEmail (String email);

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

}
