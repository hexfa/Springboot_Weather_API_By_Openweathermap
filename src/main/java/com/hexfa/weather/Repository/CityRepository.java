package com.hexfa.weather.Repository;

import com.hexfa.weather.Entity.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface CityRepository extends CrudRepository<City, Integer> {

    @Query("SELECT c FROM City c WHERE c.population = ?1")
    Collection<City> Get_City_By_Population(int population);

    @Query("SELECT c FROM City c WHERE c.area like ?1")
    Collection<City> Get_City_By_َArea(String area);

    @Query("SELECT c FROM City c WHERE c.area like %?1% and c.population=?2")
    Collection<City> Get_City_By_َArea_And_Population(String area, int population);
}