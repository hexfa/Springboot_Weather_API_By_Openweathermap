package com.hexfa.weather.Model.ListForecastItem;

import com.hexfa.weather.Model.CityItem;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseCitiesForecast {
	@JsonProperty("cnt")
	private int cnt;
	@JsonProperty("list")
	private List<CityItem> list;

	public int getCnt(){
		return cnt;
	}

	public List<CityItem> getList(){
		return list;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void setList(List<CityItem> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ResponseCityForecast{" +
				"cnt=" + cnt +
				", list=" + list +
				'}';
	}
}