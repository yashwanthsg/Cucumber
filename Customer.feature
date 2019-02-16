#Author: yashwanth

Feature: 
  Scenario: To test the add customer functionality 
    Given The user is in telecom home page
    And The user naviagtes to add customer page
    When The user fill in the form details
    And The user submits the form
    Then The customer should see the customer id is generated
    
  