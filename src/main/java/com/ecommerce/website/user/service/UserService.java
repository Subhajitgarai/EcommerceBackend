package com.ecommerce.website.user.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public ResponseEntity<?> login(String userEmail, String userPass);
    public ResponseEntity<?>updatePass(String userEmail,String oldPass, String newPass);
}
