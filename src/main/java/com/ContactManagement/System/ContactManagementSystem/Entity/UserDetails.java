package com.ContactManagement.System.ContactManagementSystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="User_Details")
public class UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    @NotEmpty(message = "This cannot be empty.")
    @Size(min = 4,max = 100,message = "The Name should be minimum 4 characters")
    private String name;

    @Column(name = "Address")
    @NotNull(message = "The Address is required.")
    private String address;

    @Column(name = "CountryCode")
    @NotEmpty(message = "CountryCode must be entered.")
    @Size(min = 2,max = 2,message = "CountryCode must be 2 Characters.")
    private int countryCode;

    @Column(name = "PhoneNumber", unique = true)
    @NotEmpty(message = "The PhoneNumber is required")
    @Size(min = 10,max = 10,message = "PhoneNumber must be at least 10 characters")
    private long phoneNumber;

    @Column(name = "Email")
    @Email(message = "Email Should be valid")
    private String email;

    public UserDetails(String name, String address, int countryCode, long phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
