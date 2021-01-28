#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
      
Feature: Weather
  In order to improve my hike today
  As a keen hiker
  I want to be able to view today's weather
  
  @Smoke @Regression
  Scenario: Get the high level weather forecast
    Given I have an internet connection
    When I have successfully downloaded the weather data
    Then I can see the weather and temperature for today
