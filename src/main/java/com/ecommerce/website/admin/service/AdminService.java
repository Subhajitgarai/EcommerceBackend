package com.ecommerce.website.admin.service;

import com.ecommerce.website.admin.entity.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    public UserDetails addNewUser(UserDetails userDetails);
    public List<UserDetails> getAllUsers();
    public ResponseEntity<?> getSingleUser(String userEmail);
    public ResponseEntity<?>deleteUserByEmail(String userEmail);
    public  ResponseEntity<?> updateUserDetails(UserDetails userDetails);
}
