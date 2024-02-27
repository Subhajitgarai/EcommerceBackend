package com.ecommerce.website.user.controller;

import com.ecommerce.website.user.entity.Cart;
import com.ecommerce.website.user.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @PostMapping("/add")
    public Cart add(@RequestBody Cart cart)
    {
        return cartService.add(cart);
    }
    @GetMapping("/fetch")
    public List<Cart> get()
    {
        return cartService.get();
    }
    @DeleteMapping("/delete/{productId}")
    public String del(@PathVariable String productId)
    {
        return cartService.del(productId);
    }
}
