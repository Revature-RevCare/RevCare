//package com.revature.Spring.controllers;
//
//import com.revature.Spring.models.PatientDiagnosis;
//import com.revature.Spring.models.User;
//import com.revature.Spring.services.NurseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/nurses")
//public class  NurseController {
//
//    private NurseService ns;
//
//    @Autowired
//    public NurseController(NurseService ns){
//        this.ns = ns;
//    }
//
//    @GetMapping
//    public List<PatientDiagnosis> findByConfirm(@RequestBody Boolean confirm){
//        return ns.findByConfirm(confirm);
//    }
//
//    @GetMapping("/{lastname}")
//    public User findUser(@RequestBody String last){
//        return ns.findByLast(last);
//    }
//}
