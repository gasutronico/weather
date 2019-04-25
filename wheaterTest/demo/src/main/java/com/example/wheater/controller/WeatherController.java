/**
 * 
 */
package com.example.wheater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.wheater.dto.CityWeather;
import com.example.wheater.service.WeatherService;

/**
 * @author Arturo
 *
 */
@Controller
public class WeatherController {

	@Autowired
	WeatherService service;

	/**
	 * 
	 * @param cityWeather
	 * @return
	 */
	@GetMapping("/weather")
	public String sendForm(CityWeather cityWeather) {
		return "getWeatherByCityId";
	}

	/**
	 * 
	 * @param cityWeather
	 * @return
	 */
	@GetMapping("/weatherByCityId")
	public String processForm(CityWeather cityWeather) {
		service.getWeatherByCityId(cityWeather);
		return "showResult";
	}

	

}
