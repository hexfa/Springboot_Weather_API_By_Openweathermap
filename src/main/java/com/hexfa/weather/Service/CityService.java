package com.hexfa.weather.Service;

import com.hexfa.weather.Entity.City;
import com.hexfa.weather.Helper.CityAPI;
import com.hexfa.weather.Helper.WeatherAPI;
import com.hexfa.weather.Model.CityInfo.City_Info;
import com.hexfa.weather.Model.CityInfo.Coord;
import com.hexfa.weather.Model.CityItem;
import com.hexfa.weather.Model.FiveDayForecast.Response5Day3Hour;
import com.hexfa.weather.Model.Result;
import com.hexfa.weather.Model.ViewModel.AddCityViewModel;
import com.hexfa.weather.Model.ViewModel.City_ex;
import com.hexfa.weather.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public Result<City> AddCity(AddCityViewModel model) {

        City c = new City();
        CityAPI api = new CityAPI();
        List<City_Info> info_list =  api.Get_by_name(model.getName());
        try
        {
            City_Info info = info_list.get(0);

            c.setCityID(info.getId());
            c.setArea(model.getArea());
            c.setPopulation(model.getPopulation());
            c.setName(model.getName());
            c.setCountry(info.getCountry());
            c.setId(0);
            cityRepository.save(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new Result<>("City name not found");
        }

        return new Result<>(c);
    }

    public Result<City> updateCity(AddCityViewModel model,int id) {

        Optional<City> c;

        try
        {
            c = cityRepository.findById(id);
            if(c.isEmpty())
                return new Result<>("City not found.");
            c.get().setArea(model.getArea());
            c.get().setPopulation(model.getPopulation());
            c.get().setName(model.getName());
            cityRepository.save(c.get());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new Result<>("City not found");
        }

        return new Result<>(c.get());
    }
    public Result<Iterable<City>> GetAll()
    {
        try
        {
            return new Result<>(cityRepository.findAll());
        }
        catch(Exception e) {
            return new Result<>("Server Error");
        }
    }

    public Result<Response5Day3Hour> getAreaForecastInformation(int lat,int lon,Boolean fiveDay)
    {
        try
        {
            Response5Day3Hour response5Day3Hour=new Response5Day3Hour();
            WeatherAPI api = new WeatherAPI();

            if (fiveDay!=null && fiveDay){
                response5Day3Hour=api.get5Day3HourForecastInformation(lat,lon);
            }else {
                CityItem cityItem=api.getAreaForecastInformation(lat,lon);
                List<CityItem> array=new ArrayList<>();
                array.add(cityItem);
                response5Day3Hour.setList(array);
            }

            return new Result<>(response5Day3Hour);

        }
        catch(Exception e) {
            return new Result<>("Server Error");
        }
    }

    public Result<Response5Day3Hour> get5Day3HourForecastInformation(int id)
    {
        try
        {
            Optional<City> c;
            c = cityRepository.findById(id);
            if(c.isEmpty())
                return new Result<>("City not found.");

            CityAPI capi = new CityAPI();
            WeatherAPI api = new WeatherAPI();

            Coord cord = capi.Get(c.get().getCityID()).getCoord();


            return new Result<>(api.get5Day3HourForecastInformation(cord.getLat(),cord.getLon()));

        }
        catch(Exception e) {
            return new Result<>("Server Error");
        }
    }

    public Result<Response5Day3Hour> getCityForecastInformation(int id,Boolean fiveDay)
    {
        try
        {
            Response5Day3Hour response5Day3Hour=new Response5Day3Hour();
            Optional<City> c;
            c = cityRepository.findById(id);
            if(c.isEmpty())
                return new Result<>("City not found.");

            CityAPI capi = new CityAPI();
            WeatherAPI api = new WeatherAPI();
            Coord cord = capi.Get(c.get().getCityID()).getCoord();

            if (fiveDay!=null && fiveDay){
                response5Day3Hour=api.get5Day3HourForecastInformation(cord.getLat(),cord.getLon());
            }else {
                CityItem cityItem=api.getCityForecastInformation(c.get().getCityID());
                List<CityItem> array=new ArrayList<>();
                array.add(cityItem);
                response5Day3Hour.setList(array);
            }

            return new Result<>(response5Day3Hour);

        }
        catch(Exception e) {
            return new Result<>("Server Error");
        }
    }

    public Result<Iterable<City_ex>> getCitiesForecastInformation(Integer population,String area)
    {
        try
        {
            Iterable<City> db_output ;
            if (population==null && area==null){
                db_output=cityRepository.findAll();
            }else if (area == null){
                db_output=cityRepository.Get_City_By_Population(population);
            }else if (population==null){
                db_output=cityRepository.Get_City_By_َArea(area);
            }else {
                db_output=cityRepository.Get_City_By_َArea_And_Population(area,population);
            }
            List<City> c = new ArrayList<>();
            List<Integer> ids = new ArrayList<>();
            for (City city:db_output) {
                c.add(city);
                ids.add(city.getCityID());
            }
            WeatherAPI api = new WeatherAPI();
            List<CityItem> res = api.getCitiesForecastInformation(ids).getList();
            int len = res.size();
            List<City_ex> output = new ArrayList<>();
            for(int i = 0;i < len;i++)
            {
                City_ex item = new City_ex();
                CityItem info = res.get(i);
                City city = c.get(i);

                item.setCityID(city.getCityID());
                item.setArea(city.getArea());
                item.setCountry(city.getCountry());
                item.setName(city.getName());
                item.setPopulation(city.getPopulation());
                item.setId(city.getId());

                item.setHumidity(info.getMain().getHumidity());
                item.setWeather(info.getWeather().get(0).getDescription());
                item.setTemp_max(info.getMain().getTempMax());
                item.setTemp_min(info.getMain().getTempMin());

                output.add(item);
            }
            return  new Result<>(output);
        }
        catch(Exception e) {
            return new Result<>("Server Error");
        }
    }
    public Result<City> DeleteCity(int id) {

        try
        {
            cityRepository.deleteById(id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new Result<>("City not found");
        }

        return new Result<>(new City());
    }

}
