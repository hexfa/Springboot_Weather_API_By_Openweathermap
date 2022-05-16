package com.hexfa.weather.Repository;

import com.hexfa.weather.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
    Collection<User> Login(String username, String password);

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Collection<User> Get_By_Username(String username);

    @Query("SELECT u FROM User u WHERE u.first_name like %?1%")
    Collection<User> Get_By_Firstname(String firstname);

    @Query("SELECT u FROM User u WHERE u.last_name like %?1%")
    Collection<User> Get_By_LastName(String lastname);

    @Query("SELECT u FROM User u WHERE u.first_name like %?1% and u.last_name like %?2%")
    Collection<User> Get_By_FirstName_And_LastName(String firstname,String lastname);

}