package com.ecommerce.website.seller.dao;

import com.ecommerce.website.seller.entities.SellerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerDao extends JpaRepository<SellerDetails,String> {
    //@Query("select  u from SellerDetails u where u.sellerEmail=:b and u.password=:p")
    public Optional<SellerDetails>findBySellerEmail(String sellerEmail);

}
