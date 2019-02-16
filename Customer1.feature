#Author: yashwanth

Feature: 
  Scenario: To add customer functionality 
    Given The user is in home page
    And The user naviagtes to addcustomer page
    When The user fill the form details
    |Yashwanth|Kumar|Yashwanth121294@gmail.com|Taramani|97508000006|
    And The user submits form
    Then The customer should see customer id is generated
    
  