package com.revature.Spring.controllers;


import com.revature.Spring.models.User;
import com.revature.Spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * Controller class UserController maps to /users
 * <br><br>
 * <b>Methods</b>
 *  <ul>
 *      <li>addUser Creates a new user in the DB</li>
 *      <li>getAllUsers Returns all the users</li>
 *      <li>getUser Gets a single user</li>
 *      <li>updateUser Changes information for a given user</li>
 *      <li>deleteUser Deletes a user for a given id</li>
 *  </ul>
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;

    }

    //CREATE

    /**
     * POST method addUser maps to /addUser
     * consumes application/json
     * produces application/json
     * @param user User object
     */
    @PostMapping(path ="/addUser", consumes = "application/json", produces = "application/json")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    //READ

    /** GET method getAllUsers maps to /find
     *
     * @return a List of all users.
     */
    @GetMapping(path ="/find")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    /**
     *  GET method getUser maps to /find/user_id
     * @return a user for a given id
     */
    @GetMapping(path ="/find/{user_id}")
    public User getUser(@PathVariable Integer user_id){
        return userService.getUser(user_id);
    }


    //UPDATE

    /**
     * PUT method updateUser maps to /update/user_id
     * No return value, it changes the information for a given user in the DB.
     * @param user_id Integer containing a user id
     * @param user User object
     */
    @PutMapping(path ="/update/{user_id}")//, consumes = "application/json", produces = "application/json")
    public void updateUser (@PathVariable Integer user_id, @RequestBody User user){
//        Users u = userService.getUser(user_id);

        if (Objects.equals(user_id, user.getUser_id())){ // compare the 2 user IDs
            userService.updateUser(user);
        }
    }

    //DELETE - deleteUser. This path will help to delete a user.

    /**
     * DELETE method deleteUser maps to /delete/user_id
     * no return value, removes a user from the DB.
     * @param user_id Integer containing a given user id
     */
    @DeleteMapping(path ="/delete/{user_id}")
    public void deleteUser (@PathVariable Integer user_id){
        User u = userService.getUser(user_id);
        userService.deleteUser(u);
    }

}
