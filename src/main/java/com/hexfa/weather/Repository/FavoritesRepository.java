package com.hexfa.weather.Repository;

import com.hexfa.weather.Entity.City;
import com.hexfa.weather.Entity.Favorites;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface FavoritesRepository extends CrudRepository<Favorites, Integer>
{
    @Query("SELECT f FROM Favorites f WHERE f.UserId = ?1")
    Collection<Favorites> Get_By_UserId(int UserId);

    @Query("SELECT f FROM Favorites f WHERE f.UserId = ?1 and f.CityId = ?2")
    Collection<Favorites> Get(int UserId, int CityId);
}
