package com.dysontest;

import java.io.IOException;

import org.junit.Assert;

import com.pages.OutdoorPage;
import com.pages.WeatherPage;

import appiumdriver.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefintion {
	private OutdoorPage outdoor;
	private WeatherPage weather;
	public AndroidDriver driverClass=new AndroidDriver();
	AppiumDriver<MobileElement> driver;

	@Before
	public void start_Driver() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		driver=driverClass.setUpDriver();
		
		outdoor = new OutdoorPage(driver);
		weather = new WeatherPage(driver);
	}
	
	@Given("I have an internet connection")
	public void i_have_an_internet_connection() {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertEquals("Connected",outdoor.connection.getText());
			
	}

	@When("I have successfully downloaded the weather data")
	public void i_have_successfully_downloaded_the_weather_data() {
	    // Write code here that turns the phrase above into concrete actions
		
		outdoor.fetchdata.click();
		
		Assert.assertEquals("Data Collected", outdoor.datacollected_verification.getText());
		
		outdoor.Viewresults.click();
	}

	@Then("I can see the weather and temperature for today")
	public void i_can_see_the_weather_and_temperature_for_today() {
	    // Write code here that turns the phrase above into concrete actions
		
		
		System.out.println(weather.weatherinfo.getText());
		Assert.assertTrue(weather.weatherinfo.isDisplayed());
		
		System.out.println(weather.temperatureinfo.getText());
		Assert.assertTrue(weather.temperatureinfo.isDisplayed());
	}
	
	@After
	public void close_Driver() {
	    // Write code here that turns the phrase above into concrete actions
		weather.done.click();
		driverClass.closeDriver();
	}

}
