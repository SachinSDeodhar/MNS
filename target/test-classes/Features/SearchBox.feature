Feature: Search Box Feature

Scenario: verify the search component by entering product keyword

Given Edge browser is launch
Given Url is open
When User searches lives women to in search component
Then Verify that all result belongs to women

Scenario: verify search magnifire is clickable or not
Given Edge browser is launch
Given Url is open
When user click on magnifire 
Then user should be able to click on the search magnifier

Scenario: veriry the search componant by entering the food product dropdownlist suggest or not

Given Edge browser is launch
Given Url is open
When user enter the food keyword
Then suggetion is correct or not

