package com.ecommerce.website.seller.entities;

import com.ecommerce.website.user.entity.Cart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_details") // Specify the table name explicitly
public class ProductDetails {
    @Id
    private String productId;
    private String productName;
    private String productPrice;
    private String productLocation;
//    @OneToMany(cascade = CascadeType.ALL,targetEntity = Cart.class)
//    @JoinColumn(name="productId",referencedColumnName = "productId")
//    private List<Cart> cart;
}
