package com.ecommerce.website.user.controller;

import com.ecommerce.website.user.entity.OrderDetails;
import com.ecommerce.website.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    //User Login
    @GetMapping("/login")
    public ResponseEntity<?> userLogin(@RequestParam String userEmail, @RequestParam String userPass){
       return userService.login(userEmail,userPass);
    }
    //Update Password
    @PutMapping("/updatepass")
    public ResponseEntity<?> updateUserPassword(@RequestParam String userEmail,@RequestParam String oldPass, @RequestParam String newPass){
        return userService.updatePass(userEmail,oldPass,newPass);
    }
    @PostMapping("/orders/placeorder")
    public OrderDetails placeOrder(@RequestBody OrderDetails orderDetails){
        return userService.addNewOrder(orderDetails);
    }
    @GetMapping("/orders/getall")
    public List<OrderDetails> getAllOrderDetails(){
       return userService.getAllOrders();
    }
    //Get all OrdersByUserId
    @GetMapping("/orders/{userEmail}")
    public List<OrderDetails> getAllOrderDetailsByUserId(@PathVariable String userEmail){
       return userService.getOrderByUserId(userEmail);
    }
    //Get Orders By OrderId
    @GetMapping("/orders/id/{orderId}")
    public ResponseEntity<?> getOrderDetailsByOrderId(@PathVariable int orderId){
       return userService.getOrdersByOrderId(orderId);
    }



}
