package com.ecommerce.website.admin.controller;

import com.ecommerce.website.admin.entity.UserDetails;
import com.ecommerce.website.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/users/add")
    public UserDetails addNewUserDetails(@RequestBody UserDetails userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        return adminService.addNewUser(userDetails);
    }

    @GetMapping("/users/{userEmail}")
    public ResponseEntity<?> getSingleUserDetails(@PathVariable String userEmail){
        return adminService.getSingleUser(userEmail);
    }
    @GetMapping("/users")
    public List<UserDetails> getAllUserDetails(){
       return adminService.getAllUsers();
    }
    @DeleteMapping("/users/delete/{userEmail}")
    public ResponseEntity<?> deleteByUserId(@PathVariable String userEmail){
       return adminService.deleteUserByEmail(userEmail);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUserDetails(@RequestBody UserDetails user){
        return adminService.updateUserDetails(user);
    }
    @GetMapping("/test")
    public String test(){
        return "Test!!";
    }

}
