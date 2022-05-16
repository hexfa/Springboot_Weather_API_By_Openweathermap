package com.hexfa.weather.Controllers;


import com.hexfa.weather.Entity.City;
import com.hexfa.weather.Entity.User;
import com.hexfa.weather.Model.CityItem;
import com.hexfa.weather.Model.FiveDayForecast.Response5Day3Hour;
import com.hexfa.weather.Model.Result;
import com.hexfa.weather.Model.ViewModel.AddCityViewModel;
import com.hexfa.weather.Model.ViewModel.City_ex;
import com.hexfa.weather.Model.ViewModel.FavoritesViewModel;
import com.hexfa.weather.Service.CityService;
import com.hexfa.weather.Service.FavoritesService;
import com.hexfa.weather.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/Favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;


    @GetMapping(path="/get")
    public @ResponseBody Result<List<FavoritesViewModel>> getAll(@RequestParam int UserId)
    {
        return favoritesService.Get(UserId);
    }

    @PutMapping(path="/Insert")
    public @ResponseBody Result<Boolean> Insert(@RequestParam int UserId,@RequestParam int CityId)
    {
        return favoritesService.Insert(UserId,CityId);
    }

    @DeleteMapping(path="/Delete")
    public @ResponseBody Result<Boolean> Delete(@RequestParam int id)
    {
        return favoritesService.Remove(id);
    }
}
