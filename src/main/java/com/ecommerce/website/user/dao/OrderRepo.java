package com.ecommerce.website.user.dao;

import com.ecommerce.website.user.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepo extends JpaRepository<OrderDetails,Integer> {
    //Get All Orders By userId
    @Query("SELECT Distinct o FROM OrderDetails o JOIN o.userDetails u WHERE u.userEmail = :userEmail")
    List<OrderDetails> getAllOrdersByUserId(@Param("userEmail") String userEmail);

}
