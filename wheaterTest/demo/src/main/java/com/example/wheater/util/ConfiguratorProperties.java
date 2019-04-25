package com.example.wheater.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="general")
public class ConfiguratorProperties {

	private String appid;
	private String path;
	private String standardFormatDate;
	private String ampmFormatDate;
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * @param appid the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * @return the standardFormatDate
	 */
	public String getStandardFormatDate() {
		return standardFormatDate;
	}
	/**
	 * @param standardFormatDate the standardFormatDate to set
	 */
	public void setStandardFormatDate(String standardFormatDate) {
		this.standardFormatDate = standardFormatDate;
	}
	/**
	 * @return the ampmFormatDate
	 */
	public String getAmpmFormatDate() {
		return ampmFormatDate;
	}
	/**
	 * @param ampmFormatDate the ampmFormatDate to set
	 */
	public void setAmpmFormatDate(String ampmFormatDate) {
		this.ampmFormatDate = ampmFormatDate;
	}
	
}
