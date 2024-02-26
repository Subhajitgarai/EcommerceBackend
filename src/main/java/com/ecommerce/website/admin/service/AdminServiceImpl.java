package com.ecommerce.website.admin.service;

import com.ecommerce.website.admin.dao.AdminUserRepo;
import com.ecommerce.website.admin.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminUserRepo adminUserRepo;
    public UserDetails addNewUser(UserDetails userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        return adminUserRepo.save(userDetails);
    }


    public List<UserDetails> getAllUsers(){
        return adminUserRepo.findAll();
    }

    public ResponseEntity<?> getSingleUser(String userEmail){

        Optional<UserDetails> byEmail = adminUserRepo.findById(userEmail);
        if (byEmail.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Does not Exists !!");
        }
        else {
            return new ResponseEntity<>(byEmail.get(),HttpStatus.OK);
        }

    }
    public ResponseEntity<?>deleteUserByEmail(String userEmail){
        Optional<UserDetails> byEmail = adminUserRepo.findById(userEmail);
        if (byEmail.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Does not Exists !!");
        }
        else {
            adminUserRepo.deleteById(userEmail);
            return ResponseEntity.status(HttpStatus.OK).body("User Deleted Successfully !!");
        }
    }

    public  ResponseEntity<?> updateUserDetails(UserDetails userDetails){
        Optional<UserDetails> byId = adminUserRepo.findById(userDetails.getUserEmail());
        if (byId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User DoesNot Exists !!");
        }
        else {
            adminUserRepo.save(userDetails);
            return new ResponseEntity<>(userDetails,HttpStatus.OK);
        }

    }

}
