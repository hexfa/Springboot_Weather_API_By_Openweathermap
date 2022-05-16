package com.hexfa.weather.Service;
import com.hexfa.weather.Entity.City;
import com.hexfa.weather.Entity.Favorites;
import com.hexfa.weather.Entity.User;
import com.hexfa.weather.Helper.CityAPI;
import com.hexfa.weather.Helper.WeatherAPI;
import com.hexfa.weather.Model.CityInfo.City_Info;
import com.hexfa.weather.Model.CityInfo.Coord;
import com.hexfa.weather.Model.CityItem;
import com.hexfa.weather.Model.FiveDayForecast.Response5Day3Hour;
import com.hexfa.weather.Model.Result;
import com.hexfa.weather.Model.ViewModel.AddCityViewModel;
import com.hexfa.weather.Model.ViewModel.City_ex;
import com.hexfa.weather.Model.ViewModel.FavoritesViewModel;
import com.hexfa.weather.Repository.CityRepository;
import com.hexfa.weather.Repository.FavoritesRepository;
import com.hexfa.weather.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class FavoritesService {

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;

    public Result<Boolean> Insert(int UserId,int CityId)
    {
        try
        {
            Collection<Favorites> f;
            f = favoritesRepository.Get(UserId,CityId);
            if(f.isEmpty())
                return new Result<>("exists");

            Optional<User> us;
            us = userRepository.findById(UserId);
            if (us.isEmpty())
                return new Result<>("User not found");

            Optional<City> c;
            c = cityRepository.findById(CityId);
            if (c.isEmpty())
                return new Result<>("City not found");

            Favorites nf = new Favorites();

            nf.setId(0);
            nf.setUserId(UserId);
            nf.setCityId(CityId);
            favoritesRepository.save(nf);
        }
        catch (Exception ex)
        {
            return new Result<>("Server Error");
        }

        return new Result<>(true);
    }

    public  Result<Boolean> Remove(int id)
    {
        try
        {
            favoritesRepository.deleteById(id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new Result<>("not found");
        }

        return new Result<>(true);
    }

    public Result<List<FavoritesViewModel>> Get(int UserId)
    {
        Collection<Favorites> f;
        f = favoritesRepository.Get_By_UserId(UserId);
        List<FavoritesViewModel> list = new ArrayList<>();
        for (Favorites fv: f) {
            Optional<City> c;
            c = cityRepository.findById(fv.getCityId());
            if (c.isEmpty())
                continue;;
            City city = c.get();
            FavoritesViewModel temp = new FavoritesViewModel();
            temp.setCountry(city.getCountry());
            temp.setId(fv.getId());
            temp.setCityId(city.getCityID());
            temp.setCityName(city.getName());
            list.add(temp);
        }
        return new Result<>(list);
    }

}
