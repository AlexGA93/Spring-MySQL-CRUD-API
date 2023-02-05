package com.alexga93.fullstackbackend.repository;
import com.alexga93.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* Repository Java interface
* Allows to group related methods with empty bodies
* Allows to be inherited by multiple classes
* */

/*
* Extends from JpaRepository interface to access to the C.R.U.D methods
* It needs to pass our "T" class (in this case is our User class)
* and a public class as the Id variable ( in this case we declared our user Id as 'private Long')
* */
public interface UserRepository extends JpaRepository<User, Long> {

}
