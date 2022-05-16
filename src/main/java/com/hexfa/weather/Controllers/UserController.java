package com.hexfa.weather.Controllers;

import com.hexfa.weather.Entity.User;
import com.hexfa.weather.Model.Result;
import com.hexfa.weather.Model.ViewModel.AddUserViewModel;
import com.hexfa.weather.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/add")
    public @ResponseBody Result<User> Add (@RequestBody AddUserViewModel model)  {
        return userService.Add(model);
    }

    @GetMapping(path="/getall")
    public @ResponseBody Result<Iterable<User>> getAll(@RequestParam(required = false) String firstName,
                                                       @RequestParam(required = false) String lastName) {return userService.GetAll(firstName,lastName);}

    @PostMapping(path="/Update")
    public @ResponseBody Result<User> Update (@RequestParam int id,@RequestBody AddUserViewModel city)  {
        return userService.Update(city,id);
    }
    @DeleteMapping (path="/Delete")
    public @ResponseBody Result<User> delete(@RequestParam int id) {return userService.Delete(id);}

    @DeleteMapping (path="/get")
    public @ResponseBody Result<User> get(@RequestParam int id) {return userService.get(id);}


}
