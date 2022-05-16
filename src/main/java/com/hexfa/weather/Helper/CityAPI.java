package com.hexfa.weather.Helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexfa.weather.Model.CityInfo.City_Info;
import org.springframework.core.io.ClassPathResource;


import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CityAPI {


    public City_Info[] Load()
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("city.json");
            InputStream inputStream = resource.getInputStream();
            byte[] b = inputStream.readAllBytes();
            String data = new String(b, StandardCharsets.UTF_8);
            City_Info[] c = mapper.readValue(data, City_Info[].class);
            return c;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public City_Info Get(int id)
    {

        try
        {
            City_Info[] c = Load();
            for (City_Info i : c)
            {
                if(i.getId().equals(id))
                    return i;
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return  null;


    }


    public List<City_Info> Get_by_con(String Con)
    {
        List<City_Info> output = new ArrayList<>();
        try
        {
            City_Info[] all = Load();

            for (City_Info i : all)
            {
                if(i.getCountry().equals(Con))
                    output.add(i);
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return  output;
    }

    public List<City_Info> Get_by_name(String name)
    {
        List<City_Info> output = new ArrayList<>();
        try
        {
            City_Info[] all = Load();

            for (City_Info i : all)
            {
                if(i.getName().equalsIgnoreCase(name))
                    output.add(i);
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return  output;
    }


}
