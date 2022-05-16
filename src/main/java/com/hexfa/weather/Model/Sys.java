package com.hexfa.weather.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sys{
	@JsonProperty("country")
	private String country;
	@JsonProperty("sunrise")
	private int sunrise;
	@JsonProperty("timezone")
	private int timezone;
	@JsonProperty("sunset")
	private int sunset;

	public String getCountry(){
		return country;
	}

	public int getSunrise(){
		return sunrise;
	}

	public int getTimezone(){
		return timezone;
	}

	public int getSunset(){
		return sunset;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setSunrise(int sunrise) {
		this.sunrise = sunrise;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public void setSunset(int sunset) {
		this.sunset = sunset;
	}

	@Override
	public String toString() {
		return "Sys{" +
				"country='" + country + '\'' +
				", sunrise=" + sunrise +
				", timezone=" + timezone +
				", sunset=" + sunset +
				'}';
	}
}
