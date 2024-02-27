package com.ecommerce.website.user.dao;

import com.ecommerce.website.user.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart,String> {
}
