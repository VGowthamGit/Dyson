package com.runner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, dryRun =false,
features = { "src/test/resources" }, 
glue = { "com.dysontest" },
plugin={"pretty", "html:target/cucumber"}
)


public class runnerTest {

	AppiumDriver<MobileElement> driver;
	/*
	 * Monochrome used to make the console output readable
	 * dry run is to check all the Gherkin line has a implementation
	 * Tilt ~ symbol used to ignore/exclude some scenarios
	 * Json is default format of report
	 * To run with TestNG have to implement abstract testng cucumber 
	 * Background used as prerequisite
	 * Hooks are @before and @after
	 * 	 */
	public AppiumDriver<MobileElement> setUpDriver() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "sdk_gphone_x86_arm");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		
		cap.setCapability("appPackage", "com.dyson.recruitment.test");
		cap.setCapability("appActivity", "com.dyson.recruitment.test.ui.splash.SplashScreenActivity");
		
		URL url =new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Application Started");
		return driver;
	}
	public void closeDriver(){
		  
		  if(driver!=null) {
		   driver.quit();
		  }
   }
}
