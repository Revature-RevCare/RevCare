package com.revature.Spring.services;

import com.revature.Spring.models.User;
import com.revature.Spring.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * UserDetailsServiceImpl implements UserDetailsService
 * contains override transactional method loadUserByUsername
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;


    /**
     * loadUserByUsername
     * @param username String containing given username
     * @return UserDetails object via UserDetailsImpl method build
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

//    @Override
//    @Transactional
//    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
//
//        User user = userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User Not Found with email: " + email));
//
//
//        return UserDetailsImpl.build(user);





}

