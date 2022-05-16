package com.hexfa.weather.Service;

import com.hexfa.weather.Entity.User;
import com.hexfa.weather.Model.Result;
import com.hexfa.weather.Model.ViewModel.AddUserViewModel;
import com.hexfa.weather.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private User Login(String Username,String Password) {
        Collection<User> users = userRepository.Login(Username, Password);
        if (users.isEmpty())
            return null;
        return users.stream().findFirst().get();
    }
    public Result<User> Add(AddUserViewModel model) {

        User u = new User();

        try
        {
            Collection<User> ExistUser = userRepository.Get_By_Username(model.getUsername());
            if(!ExistUser.isEmpty())
                return new Result<>("Username exists");
            u.setEmail(model.getEmail());
            u.setFirst_name(model.getFirst_name());
            u.setId(0);
            u.setLocation(model.getLocation_lat() + "," + model.getLocation_lon());
            u.setPassword(model.getPassword());
            u.setUsername(model.getUsername());
            u.setLast_name(model.getLast_name());
            userRepository.save(u);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new Result<>("Error Savnig Data");
        }

        return new Result<>(u);
    }

    public Result<User> Update(AddUserViewModel model,int id) {

        Optional<User> us;
        User u;


        try {
            us = userRepository.findById(id);
            if (us.isEmpty())
                return new Result<>("User not found");
            u = us.get();

            if (model.getUsername().equals(u.getUsername())) {
                Collection<User> ExistUser = userRepository.Get_By_Username(model.getUsername());
                if (!ExistUser.isEmpty())
                    return new Result<>("Username exists");
            }


            u.setEmail(model.getEmail());
            u.setFirst_name(model.getFirst_name());
            u.setLocation(model.getLocation_lat() + "," + model.getLocation_lon());
            u.setPassword(model.getPassword());
            u.setUsername(model.getUsername());
            u.setLast_name(model.getLast_name());
            userRepository.save(u);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result<>("Error Savnig Data");
        }

        return new Result<>(u);
    }


    public Result<Iterable<User>> GetAll(String firstname, String lastname)
    {
        try
        {

            Iterable<User> db_output ;
            if (firstname==null && lastname==null){
                db_output=userRepository.findAll();
            }else if (lastname == null){
                db_output=userRepository.Get_By_Firstname(firstname);
            }else if (firstname==null){
                db_output=userRepository.Get_By_LastName(lastname);
            }else {
                db_output=userRepository.Get_By_FirstName_And_LastName(firstname,lastname);
            }
            return new Result<>(db_output);
        }
        catch(Exception e) {
            return new Result<>("Server Error");
        }
    }

    public Result<User> get(int id)
    {
        try
        {
            Optional<User> us;
            User u = null;
            us = userRepository.findById(id);
            if (us.isEmpty())
                return new Result<>("User not found");
            return new Result<>(u);
        }
        catch(Exception e) {
            return new Result<>("Server Error");
        }
    }

    public Result<User> Delete(int id) {

        try
        {
            userRepository.deleteById(id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new Result<>("City not found");
        }

        return new Result<>(new User());
    }

}
