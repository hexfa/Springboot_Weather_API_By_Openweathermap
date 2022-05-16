package com.hexfa.weather.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherItem{
	@JsonProperty("description")
	private String description;
	@JsonProperty("main")
	private String main;
	@JsonProperty("id")
	private int id;


	public String getDescription(){
		return description;
	}

	public String getMain(){
		return main;
	}

	public int getId(){
		return id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "WeatherItem{" +
				"description='" + description + '\'' +
				", main='" + main + '\'' +
				", id=" + id +
				'}';
	}
}
