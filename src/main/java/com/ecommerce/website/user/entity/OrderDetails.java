package com.ecommerce.website.user.entity;

import com.ecommerce.website.admin.entity.UserDetails;
import com.ecommerce.website.seller.entities.ProductDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String productId;
    private String productName;
    private String payMode;

    @ManyToMany(targetEntity = UserDetails.class, cascade = CascadeType.ALL)
    private List<UserDetails> userDetails;
}
