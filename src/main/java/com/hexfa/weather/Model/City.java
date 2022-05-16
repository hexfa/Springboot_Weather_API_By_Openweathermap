package com.hexfa.weather.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City{
	@JsonProperty("country")
	private String country;
	@JsonProperty("coord")
	private Coord coord;
	@JsonProperty("name")
	private String name;
	@JsonProperty("id")
	private int id;

	public City() {
	}

	public City(String country, Coord coord, String name, int id) {
		this.country = country;
		this.coord = coord;
		this.name = name;
		this.id = id;
	}

	public String getCountry(){
		return country;
	}

	public Coord getCoord(){
		return coord;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "City{" +
				"country='" + country + '\'' +
				", coord=" + coord +
				", name='" + name + '\'' +
				", id=" + id +
				'}';
	}
}
