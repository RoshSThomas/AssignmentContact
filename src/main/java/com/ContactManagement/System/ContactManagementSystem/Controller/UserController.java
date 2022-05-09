package com.ContactManagement.System.ContactManagementSystem.Controller;

import com.ContactManagement.System.ContactManagementSystem.Entity.UserDetails;
import com.ContactManagement.System.ContactManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UserDetails")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDetails> saveUserDetails(@RequestBody UserDetails userDetails) {
        try {

            return new ResponseEntity<UserDetails>(userService.saveUserDetails(userDetails), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveall")
    public List<UserDetails> saveAllUserDetails(@RequestBody List<UserDetails> userDetails) {
        List list = new ArrayList<UserDetails>();
        for (UserDetails c : userDetails) {
            list.add(saveUserDetails(c));
        }
        userService.saveAllUserDetails(userDetails);
        return userDetails;
    }

    @GetMapping("/findall")
    public ResponseEntity<List<UserDetails>> findAll() {
        try {
            List<UserDetails> list = userService.findAll();
            if (list.isEmpty()) {
                return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    public Optional<UserDetails> findById(@PathVariable("id") int id) {
        return userService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        Optional<UserDetails> list = userService.findById(id);
        if (list.isEmpty()) {
            return "item not found";
        } else {
            userService.deleteById(id);
            return "Deleted Successfully";
        }
    }
}
