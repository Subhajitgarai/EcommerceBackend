package com.ecommerce.website.user.service;

import com.ecommerce.website.user.dao.CartRepo;
import com.ecommerce.website.user.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CartServiceImp implements  CartService{
    @Autowired
    CartRepo cartrepo;
    public Cart add(Cart cart)
    {
        return cartrepo.save(cart);
    }
    public List<Cart> get()
    {
        return cartrepo.findAll();
    }
    public String del(String productId)
    {
        String message="";
        Optional<Cart> cart=cartrepo.findById(productId);
        if(cart.isEmpty())
        {
            message="Id does not exists";
        }
        else {
            cartrepo.deleteById(productId);
            message="Deleted Successfully";
        }
        return message;
    }
}
