Feature: Check vehicle details 

 Background: 
 Given user enters URL "https://cartaxcheck.co.uk/"
 
Scenario Outline: Check various vehicles
 Given user enters	"<car registration number>"
 When user clicks search button
 Then apprropriate car details shoould be displayed 
 
 Examples: 
 |car registration number|
 |DN09HRM |
 |BW57 BOW|
 |KT17DLX |
 |SG18 HTN|


@fail
Scenario: Failed Test
Given user enter "BW57BOW"
 When user clicks search button
 Then matching details should be displayed


 