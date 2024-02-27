package com.ecommerce.website.user.service;

import com.ecommerce.website.user.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    public Cart add(Cart cart);
    public List<Cart> get();
    public String del(String productId);
}
