package com.revature.Spring.UserTest;

import com.revature.Spring.models.User;
import com.revature.Spring.repositories.UserRepo;
import com.revature.Spring.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    //Testing User services using Mockito

    @Test
    void contextLoads() {
    }

    //Inject Services and Repositories
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepo userRepo;

    //User Test cases

    //Test to see if User was added to Database
    @Test
    public void saveUserTest(){
    User user= new User(1, "mike", "mikey",
            "PHD","Doctor","test123@gmail.com", "working test mokito",
            "7085555555");
		userService.addUser(user);
    verify(userRepo, times(1)).save(user);

}

    // Test to get all Users in the database
    @Test
    public void getAllUsersTest() {
        when(userRepo.findAll()).thenReturn(Stream.of(new User(1, "mike", "mikey",
                "PHD","Doctor","test123@gmail.com", "working test mokito",
                "7085555555")).collect(Collectors.toList()));

        assertEquals(1, userService.getAllUsers().size());
    }

    // Test to get one user
    @Test
    public void getUserTest(){
        int user_id = 1;
        when(userRepo.findById(user_id)).thenReturn(Optional.of(new User(1,"mike", "mikey",
                "PHD", "Doctor", "test123@gmial.com","working test mokito",
                "7085555555")));
        assertEquals(user_id, userService.getUser(user_id).getUser_id());
    }

    // Test to see if user successfully updated or edited data from the database
    @Test
    public void updateUserTest(){
        User user= new User(1, "mike", "mikey",
                "PHD","Doctor","test123@gmail.com", "working test mokito",
                "7085555555");
        userService.updateUser(user);
        verify(userRepo, times(1)).save(user);
    }


    // Test to see if User was successfully deleted from the database
    @Test
    public void deleteUserTest(){
        User user= new User(1, "mike", "mikey",
                "PHD","Doctor","test123@gmail.com", "working test mokito",
                "7085555555");
        userService.deleteUser(user);
        verify(userRepo, times(1)).delete(user);


    }

    //Other Model tests may go here



}
