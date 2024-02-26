package com.ecommerce.website.seller.service;

import com.ecommerce.website.seller.entities.SellerDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SellerService {
    public String addseller(SellerDetails seller);
    public List<SellerDetails> getallseller();
    public Optional<SellerDetails> getoneseller(String sellerEmail);
    public ResponseEntity<?> login(String sellerId, String password);
    public ResponseEntity<?>updatePass(String userEmail,String oldPass, String newPass);
}
