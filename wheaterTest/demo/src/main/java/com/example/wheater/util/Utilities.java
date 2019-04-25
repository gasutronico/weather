package com.example.wheater.util;

public class Utilities {

	/**
	 * 
	 * @param parKelvin
	 * @return
	 */
	public static Double convertKtoC(Double parKelvin) {
		return parKelvin - 273.15;
	}
	
	/**
	 * 
	 * @param parKelvin
	 * @return
	 */
	public static Double convertKtoF(Double parKelvin) {
		return (parKelvin -273.15) * (9 / 5) + 32;
	}
	
}
