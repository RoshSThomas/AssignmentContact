package com.ContactManagement.System.ContactManagementSystem;

import com.ContactManagement.System.ContactManagementSystem.Entity.UserDetails;
import com.ContactManagement.System.ContactManagementSystem.Repository.JpaRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {
    @Autowired
    private JpaRepo jpaRepo;

    @Test
    public void ContactRepositoryMethodsTest() {
        jpaRepo.save(new UserDetails("rosh", "rosh thoppil house", 91, 1234567890L, "rosh@gmail.com"));
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(new UserDetails("somy", "somy pathanapuram villa", 91, 7902881925L, "somy@email.com"));
        userDetailsList.add(new UserDetails("sharin", "sharin kotarakara villa", 91, 2143658709L, "flin@gmail.com"));
        jpaRepo.saveAll(userDetailsList);
        jpaRepo.findById(1);
        jpaRepo.findAll().forEach(System.out::println);
        jpaRepo.deleteById(1);
    }
}
