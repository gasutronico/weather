package com.example.wheater.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.wheater.dto.CityWeather;
import com.example.wheater.util.ConfiguratorProperties;
import com.example.wheater.util.Utilities;

@Component
public class WeatherService {
	
	@Autowired
	ConfiguratorProperties properties;
	
	public CityWeather getWeatherByCityId(CityWeather cityWeather) {
		return fillResponse(cityWeather, serviceCall(cityWeather.getCityId()));
	}
	
	/**
	 * 
	 * @param parUrlService
	 * @return
	 */
	private String serviceCall(String cityId) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> call = restTemplate.getForEntity(properties.getPath() + "?id=" + cityId + "&APPID=" + properties.getAppid(),String.class);
		return call.getBody();
	}

	/**
	 * 
	 * @param cityWeather
	 * @param parServiceResponse
	 */
	private CityWeather fillResponse(CityWeather cityWeather, String parServiceResponse) {
		cityWeather.setDate(new SimpleDateFormat(properties.getStandardFormatDate()).format(new Date()));
		JSONObject jsonObject = (JSONObject) JSONValue.parse(parServiceResponse);
		JSONArray jsonArr = (JSONArray) jsonObject.get("weather");

		@SuppressWarnings("unchecked")
		Iterator<JSONObject> iterator = jsonArr.iterator();
		if (iterator.hasNext()) {
			JSONObject jsonObjectMain = iterator.next();
			cityWeather.setWeatherDescription(jsonObjectMain.get("description").toString());
		}
		JSONObject jsonObjectTemp = (JSONObject) jsonObject.get("main");
		Double kelvin = (Double) jsonObjectTemp.get("temp");
		cityWeather.setTemperatureC(String.format("%.2f", Utilities.convertKtoC(kelvin)));
		cityWeather.setTemperatureF(String.format("%.2f", Utilities.convertKtoF(kelvin)));

		JSONObject jsonObjectSys = (JSONObject) jsonObject.get("sys");
		long sunrise = (long) jsonObjectSys.get("sunrise");
		long sunset = (long) jsonObjectSys.get("sunset");

		SimpleDateFormat sdf = new SimpleDateFormat(properties.getAmpmFormatDate());
		cityWeather.setSunriseTime(sdf.format(new Date(sunrise * 1000L)));
		cityWeather.setSunsetTime(sdf.format(new Date(sunset * 1000L)));

		cityWeather.setCityName(jsonObject.get("name").toString());
		
		return cityWeather;
	}

}
