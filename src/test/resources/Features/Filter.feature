Feature: Filter feature

Scenario: This is first scenario
Given Chrome browser is launched
And url is fully opened
When user searches levis in search component
And apply men filter on search result page
Then veryfy that all results belongs to men

Scenario: 50 percent discount check
Given Chrome browser is launched
And url is fully opened
When user searches pollo in search component
And apply discount filter of percente
Then verify that all results 


