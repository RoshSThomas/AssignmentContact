package com.ContactManagement.System.ContactManagementSystem.Repository;

import com.ContactManagement.System.ContactManagementSystem.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepo extends JpaRepository<UserDetails,Integer> {

}
