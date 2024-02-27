package com.ecommerce.website.user.service;

import com.ecommerce.website.user.entity.OrderDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public ResponseEntity<?> login(String userEmail, String userPass);
    public ResponseEntity<?>updatePass(String userEmail,String oldPass, String newPass);
    public OrderDetails addNewOrder(OrderDetails orderDetails);
    public List<OrderDetails> getAllOrders();
    public List<OrderDetails> getOrderByUserId(String userId);
    public ResponseEntity<?> getOrdersByOrderId(int orderId);
}
