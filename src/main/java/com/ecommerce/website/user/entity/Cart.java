package com.ecommerce.website.user.entity;

import com.ecommerce.website.admin.entity.UserDetails;
import com.ecommerce.website.seller.entities.ProductDetails;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Cart {
    @Id
    private String  productId;
    private int userId;
    private String productName;
    private String productPrice;
    private String productStatus;
}
