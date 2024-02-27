package com.ecommerce.website.user.service;

import com.ecommerce.website.admin.entity.UserDetails;
import com.ecommerce.website.user.dao.OrderRepo;
import com.ecommerce.website.user.dao.UserRepo;
import com.ecommerce.website.user.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    //Login
    public ResponseEntity<?> login(String userEmail,String userPass){
        Optional<UserDetails> byId = userRepo.findById(userEmail);
        if (byId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User is not Registered with the database !!");
        }
        else {
            UserDetails user = byId.get();
            if (user.getUserPass().equals(userPass)){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Password !!");
            }
        }

    }

    //Update Password
    public ResponseEntity<?>updatePass(String userEmail,String oldPass, String newPass){
        Optional<UserDetails> byId = userRepo.findById(userEmail);
        if (byId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Present");
        }
        else {
            UserDetails user = byId.get();
            if (user.getUserPass().equals(oldPass)){
                user.setUserPass(newPass);
                userRepo.save(user);
                return new ResponseEntity<>(user,HttpStatus.OK);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Old Password Doesn't Matches !!");
            }

        }

    }
    //Orders
    //Place an order
    @Autowired
    private OrderRepo orderRepo;
    public OrderDetails addNewOrder(OrderDetails orderDetails){
       return orderRepo.save(orderDetails);
    }
    //Get All orders
    public List<OrderDetails> getAllOrders(){
       return orderRepo.findAll();
    }

    //Get Orders By userId
    public List<OrderDetails> getOrderByUserId(String userEmail){
        System.out.println(userEmail);
       return orderRepo.getAllOrdersByUserId(userEmail);

    }
    //Get Orders by orderId
    public ResponseEntity<?> getOrdersByOrderId(int orderId){
        Optional<OrderDetails> byId = orderRepo.findById(orderId);
        if (byId.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid orderId !!");
        }
        else {
            return new ResponseEntity<>(byId.get(),HttpStatus.OK);
        }

    }
}
