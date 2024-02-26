package com.ecommerce.website.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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
}
