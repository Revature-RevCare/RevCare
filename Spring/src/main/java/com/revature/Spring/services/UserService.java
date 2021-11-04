package com.revature.Spring.services;

import com.revature.Spring.models.User;
import com.revature.Spring.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // CREATE
    public void addUser(User user) {
        userRepo.save(user);
    }

    // READ
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(Integer user_id) {
        return userRepo.findById(user_id).orElse(null);
    }



    // UPDATE
    public void updateUser(User user) {
        userRepo.save(user);
    }

    // DELETE
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

}
