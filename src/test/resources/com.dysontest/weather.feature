#Author: venthan89@gmail.com
#Keywords Summary :Dyson app test keywords
#Feature: weather test

      
Feature: Weather
  In order to improve my hike today
  As a keen hiker
  I want to be able to view today's weather
  
  @Smoke @Regression
  Scenario: Get the high level weather forecast
    Given I have an internet connection
    When I have successfully downloaded the weather data
    Then I can see the weather and temperature for today
