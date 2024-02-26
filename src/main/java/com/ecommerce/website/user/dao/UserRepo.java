package com.ecommerce.website.user.dao;

import com.ecommerce.website.admin.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserDetails,String> {

}
