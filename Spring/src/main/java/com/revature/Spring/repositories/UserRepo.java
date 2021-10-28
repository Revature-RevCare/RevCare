package com.revature.Spring.repositories;

import com.revature.Spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByLastname(String lname);


    //test
}
