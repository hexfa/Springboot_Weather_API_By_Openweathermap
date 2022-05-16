package com.hexfa.weather.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord{
	@JsonProperty("lon")
	private int lon;
	@JsonProperty("lat")
	private int lat;

	public int getLon(){
		return lon;
	}

	public int getLat(){
		return lat;
	}

	public void setLon(int lon) {
		this.lon = lon;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "Coord{" +
				"lon=" + lon +
				", lat=" + lat +
				'}';
	}
}
