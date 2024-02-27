package com.ecommerce.website.seller.service;

import com.ecommerce.website.seller.dao.SellerDao;
import com.ecommerce.website.seller.entities.SellerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SellerServiceImp implements SellerService{
    @Autowired
    SellerDao sellerDao;
    public String addseller(SellerDetails seller)
    {
        seller.setSellerId(UUID.randomUUID().toString());
        sellerDao.save(seller);
        return "Added successfull";

    }
    public List<SellerDetails> getallseller()
    {
        return sellerDao.findAll();
    }
    public Optional<SellerDetails> getoneseller(String sellerEmail)
    {
        return sellerDao.findById(sellerEmail);
    }
    public ResponseEntity<?> login(String sellerEmail, String password){
        Optional<SellerDetails> byEmail = sellerDao.findBySellerEmail(sellerEmail);
        if (byEmail.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seller is not Registered with the database !!");
        }
        else {
            SellerDetails seller = byEmail.get();
            if (seller.getPassword().equals(password)){
                return new ResponseEntity<>(seller, HttpStatus.OK);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Password !!");
            }
        }

    }
    public ResponseEntity<?>updatePass(String sellerEmail,String oldPass, String newPass){
        Optional<SellerDetails> byEmail = sellerDao.findBySellerEmail(sellerEmail);
        if (byEmail.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seller Not Present");
        }
        else {
            SellerDetails seller = byEmail.get();
            if (seller.getPassword().equals(oldPass)){
                seller.setPassword(newPass);
                sellerDao.save(seller);
                return new ResponseEntity<>(seller,HttpStatus.OK);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Old Password Doesn't Matches !!");
            }

        }

    }

}
