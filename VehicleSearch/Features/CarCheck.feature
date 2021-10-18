Feature: Verify Vehicles Identity

  Scenario: Verify vehicle details
    Given user enters URL "https://cartaxcheck.co.uk/"
    When I check each registration number on the website
    Then actual value should correspond with output file 