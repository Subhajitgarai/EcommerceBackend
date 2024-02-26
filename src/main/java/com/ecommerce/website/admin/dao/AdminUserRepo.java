package com.ecommerce.website.admin.dao;

import com.ecommerce.website.admin.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepo extends JpaRepository<UserDetails,String> {

}
