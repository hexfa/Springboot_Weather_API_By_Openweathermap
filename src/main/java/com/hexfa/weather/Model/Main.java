package com.hexfa.weather.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main{
	@JsonProperty("temp")
	private double temp;
	@JsonProperty("temp_min")
	private double tempMin;
	@JsonProperty("grnd_level")
	private int grndLevel;
	@JsonProperty("temp_kf")
	private int tempKf;
	@JsonProperty("humidity")
	private int humidity;
	@JsonProperty("pressure")
	private int pressure;
	@JsonProperty("sea_level")
	private int seaLevel;
	@JsonProperty("feels_like")
	private double feelsLike;
	@JsonProperty("temp_max")
	private double tempMax;

	public double getTemp(){
		return temp;
	}

	public double getTempMin(){
		return tempMin;
	}

	public int getGrndLevel(){
		return grndLevel;
	}

	public int getTempKf(){
		return tempKf;
	}

	public int getHumidity(){
		return humidity;
	}

	public int getPressure(){
		return pressure;
	}

	public int getSeaLevel(){
		return seaLevel;
	}

	public double getFeelsLike(){
		return feelsLike;
	}

	public double getTempMax(){
		return tempMax;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	public void setGrndLevel(int grndLevel) {
		this.grndLevel = grndLevel;
	}

	public void setTempKf(int tempKf) {
		this.tempKf = tempKf;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public void setSeaLevel(int seaLevel) {
		this.seaLevel = seaLevel;
	}

	public void setFeelsLike(double feelsLike) {
		this.feelsLike = feelsLike;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	@Override
	public String toString() {
		return "Main{" +
				"temp=" + temp +
				", tempMin=" + tempMin +
				", grndLevel=" + grndLevel +
				", tempKf=" + tempKf +
				", humidity=" + humidity +
				", pressure=" + pressure +
				", seaLevel=" + seaLevel +
				", feelsLike=" + feelsLike +
				", tempMax=" + tempMax +
				'}';
	}
}
