package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;




@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(monochrome = true, dryRun =false,
features = { "src/test/resources" }, 
glue = { "com.dysontest" },
plugin={"pretty", "html:target/cucumber"})


public class runnerTest {
	/*
	 * Monochrome used to make the console output readable
	 * dry run is to check all the Gherkin line has a implementation
	 * Tilt ~ symbol used to ignore/exclude some scenarios
	 * Json is default format of report
	 * To run with TestNG have to implement abstract testng cucumber 
	 * Background used as prerequisite
	 * Hooks are @before and @after
	 * 	 */
	
}
