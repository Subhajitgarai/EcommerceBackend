package com.ecommerce.website.user.controller;

import com.ecommerce.website.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    //User Login
    @GetMapping("/login")
    public ResponseEntity<?> userLogin(@RequestParam String userEmail, @RequestParam String userPass){
       return userService.login(userEmail,userPass);
    }
    //Update Password
    @PutMapping("/updatepass")
    public ResponseEntity<?> updateUserPassword(@RequestParam String userEmail,@RequestParam String oldPass, @RequestParam String newPass){
        return userService.updatePass(userEmail,oldPass,newPass);
    }


}
