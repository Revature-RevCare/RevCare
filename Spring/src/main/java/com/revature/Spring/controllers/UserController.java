package com.revature.Spring.controllers;


import com.revature.Spring.models.User;
import com.revature.Spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;

    }

    //CREATE
    @PostMapping(path ="/addUser", consumes = "application/json", produces = "application/json")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    //READ

    @GetMapping(path ="/find")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping(path ="/find/{user_id}")
    public User getUser(@PathVariable Integer user_id){
        return userService.getUser(user_id);
    }


    //UPDATE

    @PutMapping(path ="/update/{user_id}")//, consumes = "application/json", produces = "application/json")
    public void updateUser (@PathVariable Integer user_id, @RequestBody User user){
//        Users u = userService.getUser(user_id);

        if (Objects.equals(user_id, user.getUser_id())){ // compare the 2 user IDs
            userService.updateUser(user);
        }

    }

    //DELETE - deleteUser. This path will help to delete a user.
    @DeleteMapping(path ="/delete/{user_id}")
    public void deleteUser (@PathVariable Integer user_id){
        User u = userService.getUser(user_id);
        userService.deleteUser(u);
    }

}
