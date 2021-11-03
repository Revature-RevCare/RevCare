package com.revature.Spring.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {

    UserDetails loadUserByEmail (String email) throws UsernameNotFoundException;

    UserDetails loadUserByUsername (String username) throws UsernameNotFoundException;
}
