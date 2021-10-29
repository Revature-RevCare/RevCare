//package com.revature.Spring.UserTest;
//
//
//import com.revature.Spring.controllers.UserController;
//import com.revature.Spring.models.User;
//import com.revature.Spring.repositories.UserRepo;
//import com.revature.Spring.services.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class UserControllerTest {
//
//    @Autowired
//    private UserController userController;
//
//    @MockBean
//    private UserService userService;
//
//    @MockBean
//    private UserRepo userRepo;
//
//
//
//
//    @Test
//    public void contextLoads(){
//
//    }
//
//
//
//    @Test
//    public void saveUserTest(){
//        User user= new User(1, "mike", "mikey",
//                "PHD","Doctor","test123@gmail.com", "working test mokito",
//                "7085555555");
//        userController.addUser(user);
//        verify(userRepo, times(1)).save(user);
//
//    }
//
//    @Test
//    public void getAllUsersTest() {
//        when(userRepo.findAll()).thenReturn(Stream.of(new User(1, "mike", "mikey",
//                "PHD","Doctor","test123@gmail.com", "working test mokito",
//                "7085555555")).collect(Collectors.toList()));
//
//        assertEquals(1, userController.getAllUsers().size());
//    }
//
//    // Test to get one user
//    @Test
//    public void getUserTest(){
//        int user_id = 1;
//        when(userRepo.findById(user_id)).thenReturn(Optional.of(new User(1,"mike", "mikey",
//                "PHD", "Doctor", "test123@gmial.com","working test mokito",
//                "7085555555")));
//        assertEquals(user_id, userController.getUser(user_id).getUser_id());
//    }
//
//    // Test to see if user successfully updated or edited data from the database
////    @Test
////    public void updateUserTest(){
////        int user_id = 1;
////        User user= new User(1, "mike", "mikey",
////                "PHD","Doctor","test123@gmail.com", "working test mokito",
////                "7085555555");
////        userController.updateUser(user_id, user);
////        verify(userRepo, times(1)).save(user);
////    }
//
//
//    // Test to see if User was successfully deleted from the database
////    @Test
////    public void deleteUserTest(){
////        int user_id = 1;
////        User user= new User(1, "mike", "mikey",
////                "PHD","Doctor","test123@gmail.com", "working test mokito",
////                "7085555555");
////
////        given(userService.)
////        userController.deleteUser(user_id);
//////        verify(userRepo, times(1)).delete(user_id);
////
////
////    }
//
//    @Test
//    public void deleteUserTest(){
//        int user_id = 1;
//        User user= new User(1, "mike", "mikey",
//                "PHD","Doctor","test123@gmail.com", "working test mokito",
//                "7085555555");
//        userController.deleteUser(1);
//        verify(userRepo, times(1)).delete(user);
//
//
//    }
//
//}
