package com.revature.Spring.services;

import com.revature.Spring.models.User;
import com.revature.Spring.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService Service class
 * <br><br>
 * <b>Methods</b>
 *  <ul>
 *      <li>addUser</li>
 *      <li>getAllUsers</li>
 *      <li>getUser</li>
 *      <li>updateUser</li>
 *      <li>deleteUser</li>
 *  </ul>
 */
@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // CREATE

    /**
     * addUser
     * @param user User object to add via userRepo method save
     */
    public void addUser(User user) {
        userRepo.save(user);
    }

    // READ

    /**
     * getAllUsers
     * @return List of all User Objects via userRepo method findAll
     */
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    /**
     * getUser
     * @param user_id Integer containing given user Id to get
     * @return User object based on user id via userRepo method findById
     */
    public User getUser(Integer user_id) {
        return userRepo.findById(user_id).orElse(null);
    }



    // UPDATE

    /**
     * updateUser
     * @param user User object given to update via userRepo method save
     */
    public void updateUser(User user) {
        userRepo.save(user);
    }

    // DELETE

    /**
     * deletUser
     * @param user given User objext to delete via userRepo method delete
     */
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

}
