package com.ecommerce.website.admin.entity;

import com.ecommerce.website.user.entity.OrderDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
public class UserDetails {
    @Id
    private String userEmail;
    private String userId;
    private String userName;
    private String userAddress;
    private String userPh;
    private String userPass;
//    private List<OrderDetails>orderDetails;
}
