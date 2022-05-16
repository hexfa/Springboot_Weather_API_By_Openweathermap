package com.hexfa.weather.Model.ViewModel;

import java.util.HashMap;
import java.util.Map;

public class AddCityViewModel {
    private Integer population;
    private String name;
    private String area;

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
