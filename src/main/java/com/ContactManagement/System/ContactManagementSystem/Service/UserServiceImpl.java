package com.ContactManagement.System.ContactManagementSystem.Service;

import com.ContactManagement.System.ContactManagementSystem.Entity.UserDetails;
import com.ContactManagement.System.ContactManagementSystem.Repository.JpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private JpaRepo jpaRepo;

    @Override
    public UserDetails saveUserDetails(UserDetails userDetails) {
        return jpaRepo.save(userDetails);
    }

    @Override
    public List<UserDetails> saveAllUserDetails(List<UserDetails> userDetailsList) {
       List<UserDetails> response = (List<UserDetails>) jpaRepo.saveAll(userDetailsList);
        return response;
    }

    @Override
    public List<UserDetails> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<UserDetails> findById(int id) {
        jpaRepo.findById(id);
        return Optional.empty();
    }

    @Override
    public void deleteById(int id) {
        jpaRepo.deleteById(id);
        System.out.println("Deleted Successfully");

    }
}
