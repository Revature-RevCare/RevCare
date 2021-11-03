package com.revature.Spring.services;

import com.revature.Spring.models.User;
import com.revature.Spring.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserRepo userRepo;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User Not Found with email: " + email));


        return UserDetailsImpl.build(user);



    }
}
