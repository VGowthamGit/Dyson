package com.pages;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class weatherpage {
	public AppiumDriver<MobileElement> driver;
	
	@FindBy(how = How.ID, using = "com.dyson.recruitment.test:id/weather_display_weather_value")
	public MobileElement weatherinfo;
	
	@FindBy(how = How.ID, using = "com.dyson.recruitment.test:id/weather_display_temperature_value")
	public MobileElement temperatureinfo;
	
	public weatherpage(AppiumDriver<MobileElement> driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}
}
