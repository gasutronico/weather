/**
 * 
 */
package com.example.wheater.dto;

/**
 * @author Arturo
 *
 */
public class CityWeather {

    private String cityName;
    private String cityId;
    private String date;
    private String weatherDescription;
    private String temperatureC;
    private String temperatureF;
    private String sunriseTime;
    private String sunsetTime;
    
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWeatherDescription() {
		return weatherDescription;
	}
	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}
	public String getTemperatureC() {
		return temperatureC;
	}
	public void setTemperatureC(String temperatureC) {
		this.temperatureC = temperatureC;
	}
	public String getTemperatureF() {
		return temperatureF;
	}
	public void setTemperatureF(String temperatureF) {
		this.temperatureF = temperatureF;
	}
	public String getSunriseTime() {
		return sunriseTime;
	}
	public void setSunriseTime(String sunriseTime) {
		this.sunriseTime = sunriseTime;
	}
	public String getSunsetTime() {
		return sunsetTime;
	}
	public void setSunsetTime(String sunsetTime) {
		this.sunsetTime = sunsetTime;
	}
}
