package com.ecommerce.website.seller.dao;

import com.ecommerce.website.seller.entities.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<ProductDetails,String> {
}
