Feature: Weather forecast testing in go rest site

@weather
Scenario: AC01_TC01_Validate Whether user is able to get the weather forecast details for london
  Given Get London forecast details from open API weather
  When the response code is 200
  Then I can validate whether the response contains London weather





