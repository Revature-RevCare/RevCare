package com.revature.Spring.repositories;


import com.revature.Spring.models.ERole;
import com.revature.Spring.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo  extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);


}
