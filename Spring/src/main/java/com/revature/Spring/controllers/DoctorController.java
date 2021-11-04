//package com.revature.Spring.controllers;
//
//import com.revature.Spring.models.PatientDiagnosis;
//import com.revature.Spring.models.User;
//import com.revature.Spring.services.DoctorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/doctors")
//public class DoctorController {
//
//    private DoctorService ds;
//
//    @Autowired
//    public DoctorController(DoctorService ds){
//        this.ds = ds;
//    }
//
////    @GetMapping
////    public List<PatientDiagnosis> getAll(){
////        return ds.findAllPatientDiagnosis();
////    }
//    @GetMapping
//    public List<PatientDiagnosis> getByConfirm(@RequestBody Boolean confirm){
//        return ds.findByConfirm(confirm);
//    }
//
//    @GetMapping("/{lastname}")
//    public User getUser(@RequestBody String last_name){
//        return ds.findByLastName(last_name);
//    }
//
//
//}
