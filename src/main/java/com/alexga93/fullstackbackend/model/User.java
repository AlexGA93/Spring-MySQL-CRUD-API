package com.alexga93.fullstackbackend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


// Create model class and connect with MySQL database
// User table - @entity annotation to generate user table once we connect hthe database
@Entity
public class User {
    // All entities that we'll be using in our table
    @Id
    @GeneratedValue
    private Long id; // We want to be autogenerated
    private String username;
    private String name;
    private String email;

    //  getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}