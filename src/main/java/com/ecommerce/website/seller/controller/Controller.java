package com.ecommerce.website.seller.controller;

import com.ecommerce.website.seller.entities.SellerDetails;
import com.ecommerce.website.seller.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seller")
public class Controller {

    @Qualifier("sellerServiceImp")
    @Autowired
    SellerService sellerservice;
    @PostMapping("/add")
    public String addseller(@RequestBody SellerDetails sellerdetails)
    {
        return sellerservice.addseller(sellerdetails);
    }
    @GetMapping("/fetch")
    public List<SellerDetails> getall()
    {
        return sellerservice.getallseller();
    }
    @GetMapping("/fetch/{sellerId}")
    public Optional<SellerDetails> getoneseller(@PathVariable String sellerId)
    {
            return sellerservice.getoneseller(sellerId);
    }
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String sellerEmail, @RequestParam String password)
    {
        return sellerservice.login(sellerEmail,password);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updatepassword(@RequestParam String sellerEmail, @RequestParam String oldPass, @RequestParam String newPass)
    {
        return sellerservice.updatePass(sellerEmail,oldPass,newPass);
    }
}
