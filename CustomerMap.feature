#Author: yashwanthkumar

Feature: 
  
 Scenario: The telecome page functionality		
    Given The user telecome page
    And The navigate customer page
    When The user fill in the fields
     | Fname | yashwanth | 
      | Lname |     kumar |
      | Email |     yashwanth121294@gmail.com |
      |Address|Chennai|
      |PhNum|9750866606| 
    And The user submit
    Then The id generated
    