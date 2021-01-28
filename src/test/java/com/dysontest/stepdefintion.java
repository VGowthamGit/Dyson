package com.dysontest;

import java.io.IOException;
import java.net.URL;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.pages.outdoordata;
import com.pages.weatherpage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public class stepdefintion {
	private outdoordata outdoor;
	private weatherpage weather;
	static AppiumDriver<MobileElement> driver;	
	@Before
	public void start_Driver() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		DesiredCapabilities cap  =  new DesiredCapabilities();
		   cap.setCapability("deviceName", "sdk_gphone_x86_arm");
		   cap.setCapability("udid", "emulator-5554");
		   cap.setCapability("platformName", "Android");
		   cap.setCapability("platformVersion", "11");
		   cap.setCapability("appPackage", "com.dyson.recruitment.test");
		   cap.setCapability("appActivity", "com.dyson.recruitment.test.ui.splash.SplashScreenActivity");
		   URL url = new URL("http://127.0.0.1:4723/wd/hub");
		   driver = new AppiumDriver<MobileElement>(url,cap);
		   System.out.println("Application Started");
	}
	
	@Given("I have an internet connection")
	public void i_have_an_internet_connection() {
	    // Write code here that turns the phrase above into concrete actions
		outdoor = new outdoordata(driver);
		Assert.assertEquals("Connected",outdoor.connection.getText());
			
	}

	@When("I have successfully downloaded the weather data")
	public void i_have_successfully_downloaded_the_weather_data() {
	    // Write code here that turns the phrase above into concrete actions
		
		outdoor.fetchdata.click();
		
		Assert.assertEquals("Data Collected	", outdoor.datacollected_verification.getText());
		
		outdoor.Viewresults.click();
	}

	@Then("I can see the weather and temperature for today")
	public void i_can_see_the_weather_and_temperature_for_today() {
	    // Write code here that turns the phrase above into concrete actions
		weather = new weatherpage(driver);
		
		Assert.assertEquals("Fog",weather.weatherinfo.getText());
		
		Assert.assertEquals("10.39C",weather.temperatureinfo.getText());
	}
	
	@After
	public void close_Driver() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	    driver.quit();
	}

}
