package com.hexfa.weather.Controllers;

import com.hexfa.weather.Entity.City;
import com.hexfa.weather.Model.CityItem;
import com.hexfa.weather.Model.FiveDayForecast.Response5Day3Hour;
import com.hexfa.weather.Model.Result;
import com.hexfa.weather.Model.ViewModel.AddCityViewModel;
import com.hexfa.weather.Model.ViewModel.City_ex;
import com.hexfa.weather.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/City")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping(path = "/add")
    public @ResponseBody
    Result<City> AddCity(@RequestBody AddCityViewModel city) {
        return cityService.AddCity(city);
    }

    @GetMapping(path = "/GetCityList")
    public @ResponseBody
    Result<Iterable<City>> getAll() {
        return cityService.GetAll();
    }

    @GetMapping(path = "/getCitiesForecastInformation")
    public @ResponseBody
    Result<Iterable<City_ex>> getCitiesForecastInformation(@RequestParam(required = false) Integer population,
                                                           @RequestParam(required = false) String area) {
        return cityService.getCitiesForecastInformation(population,area);
    }

    @PostMapping(path = "/Update")
    public @ResponseBody
    Result<City> updste(@RequestParam int id, @RequestBody AddCityViewModel city) {
        return cityService.updateCity(city, id);
    }

    @DeleteMapping(path = "/Delete")
    public @ResponseBody
    Result<City> delete(@RequestParam int id) {
        return cityService.DeleteCity(id);
    }

    @GetMapping(path = "/getAreaForecastInformation")
    public @ResponseBody
    Result<Response5Day3Hour> getAreaForecastInformation(int lat,int lon,@RequestParam(required = false) Boolean fiveDay) {
        return cityService.getAreaForecastInformation(lat,lon,fiveDay);
    }

    @GetMapping(path = "/get5Day3HourForecastInformation")
    public @ResponseBody
    Result<Response5Day3Hour> get5Day3HourForecastInformation(int id) {
        return cityService.get5Day3HourForecastInformation(id);
    }

    @GetMapping(path = "/getCityForecastInformation")
    public @ResponseBody
    Result<Response5Day3Hour> getCityForecastInformation(int id,@RequestParam(required = false) Boolean fiveDay) {
        return cityService.getCityForecastInformation(id,fiveDay);
    }

}
