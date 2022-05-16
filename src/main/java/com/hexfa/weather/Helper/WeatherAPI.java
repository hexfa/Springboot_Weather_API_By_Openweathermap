package com.hexfa.weather.Helper;

import com.hexfa.weather.Model.CityItem;
import com.hexfa.weather.Model.FiveDayForecast.Response5Day3Hour;
import com.hexfa.weather.Model.ListForecastItem.ResponseCitiesForecast;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class WeatherAPI {
    public final static String API_KEY = "5be693550f7f654768f40bcf135fa598";
    public final static String BASE_UER="https://api.openweathermap.org/data/2.5/";
    private static final RestTemplate restTemplate=new RestTemplate();



    public  CityItem getAreaForecastInformation(double lat, double lon) {
        String uri = BASE_UER+"weather?lat="+lat+"&lon="+lon+"&appid="+API_KEY;
        return restTemplate.getForObject(uri, CityItem.class);
    }

    public  Response5Day3Hour get5Day3HourForecastInformation(double lat, double lon) {
        final String uri = BASE_UER+"forecast?lat="+lat+"&lon="+lon+"&appid="+API_KEY;
        return restTemplate.getForObject(uri, Response5Day3Hour.class);
    }

    public  ResponseCitiesForecast getCitiesForecastInformation(List<Integer> cities){
        StringBuilder citiesID= new StringBuilder();
        for (int city:cities
             ) {
           citiesID.append(city).append(",");
        }
        final String uri = BASE_UER+"group?id="+citiesID+"&appid="+API_KEY;
        return restTemplate.getForObject(uri, ResponseCitiesForecast.class);
    }

    public   CityItem getCityForecastInformation(int id){
        final String uri = BASE_UER+"weather?id="+id+"&appid="+API_KEY;
        return restTemplate.getForObject(uri, CityItem.class);
    }
}
