package com.hexfa.weather.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CityItem {
	@JsonProperty("dt")
	private int dt;
	@JsonProperty("coord")
	private Coord coord;
	@JsonProperty("weather")
	private List<WeatherItem> weather;
	@JsonProperty("name")
	private String name;
	@JsonProperty("main")
	private Main main;
	@JsonProperty("id")
	private int id;
	@JsonProperty("sys")
	private Sys sys;

	public int getDt(){
		return dt;
	}

	public Coord getCoord(){
		return coord;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public String getName(){
		return name;
	}

	public Main getMain(){
		return main;
	}

	public int getId(){
		return id;
	}

	public Sys getSys(){
		return sys;
	}

	public void setDt(int dt) {
		this.dt = dt;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}


	public void setWeather(List<WeatherItem> weather) {
		this.weather = weather;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	@Override
	public String toString() {
		return "Item{" +
				"dt=" + dt +
				", coord=" + coord +
				", weather=" + weather +
				", name='" + name + '\'' +
				", main=" + main +
				", id=" + id +
				", sys=" + sys +
				'}';
	}
}