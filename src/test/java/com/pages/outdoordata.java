package com.pages;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class outdoordata {
	
	public AppiumDriver<MobileElement> driver;
	
	@FindBy(how = How.ID ,   using ="com.dyson.recruitment.test:id/connection_display_icon")
	public MobileElement connection;
	
	@FindBy(how = How.ID, using = "com.dyson.recruitment.test:id/connection_display_primary_button")
	public MobileElement fetchdata;
	
	@FindBy(how = How.ID, using = "com.dyson.recruitment.test:id/fetch_data_title")
	public MobileElement datacollected_verification;
	
	@FindBy(how = How.ID, using = "com.dyson.recruitment.test:id/fetch_data_primary_button")
	public MobileElement Viewresults;
	
	
	public outdoordata(AppiumDriver<MobileElement> driver) {
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
}
}
