package com.ecommerce.website.seller.entities;

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
@Table(name = "seller_details")
public class SellerDetails {
    @Id
    private String sellerId;
    private String sellerEmail;
    private String sellerName;
    private String sellerLocation;
    private String password;
    private String sellerPh;

    @ManyToMany(cascade = CascadeType.ALL,targetEntity = ProductDetails.class)
    @JoinTable(
            name = "seller_product", // Define a unique join table name
            joinColumns = @JoinColumn(name = "seller_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductDetails> productDetails;
}
