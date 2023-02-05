package com.alexga93.fullstackbackend.controller;
import com.alexga93.fullstackbackend.exception.UserNotFoundExcepction;
import com.alexga93.fullstackbackend.model.User;
import com.alexga93.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Controller to send information to the database
* */
@RestController
public class UserController {
    //  Inject user repository
    @Autowired
    private UserRepository userRepository;

    ////////////////////////////////////////////////////////////////////////////
    // Posting data - with path - return User
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user")
    // we pass the body request of our variable with an annotation
    User postNewUser(@RequestBody User newUser){
        // return the result of posting the data in MySQL
        return userRepository.save(newUser);
    }
    ////////////////////////////////////////////////////////////////////////////
    // Get All users - return Users as List of User
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    // The user of this interface has precise control over where in the list each element is inserted.
    List<User> getAllUsers(){
        return userRepository.findAll();
    }
    ////////////////////////////////////////////////////////////////////////////
    // Get User By Id HANDLING WITH EXCEPCTIONS - return User
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        // excepction is a custom java class
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundExcepction(id));
    }
    ////////////////////////////////////////////////////////////////////////////
    // Update User Information - return User
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        // find user by id and update to store it with the changes
        return userRepository.findById(id).map(user -> {
            // log user
            System.out.print(user);
            // find user by id
            user.setUsername(newUser.getUsername());
            // set new name by User class setter
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());

            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundExcepction(id));
    }
    ////////////////////////////////////////////////////////////////////////////
    // Delete user by id
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/user/{id}")
    // String because we will return a string message as delete confirmation
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundExcepction(id);
        }
        userRepository.deleteById(id);
        return "User with id "+id+" has been deleted successfully!";
    }

}
