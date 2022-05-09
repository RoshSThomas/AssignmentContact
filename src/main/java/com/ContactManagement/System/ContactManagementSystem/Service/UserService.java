package com.ContactManagement.System.ContactManagementSystem.Service;

import com.ContactManagement.System.ContactManagementSystem.Entity.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetails saveUserDetails(UserDetails userDetails);

    List<UserDetails> saveAllUserDetails(List<UserDetails> userDetailsList);

    List<UserDetails> findAll();

    Optional<UserDetails> findById(int id);

    void deleteById(int id);

}
