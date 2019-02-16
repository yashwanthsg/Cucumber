#Author: yashwanth

Feature: 

  Scenario: The telecome page function
    Given The telecome page
    And The navigate to customer page
    When The user fill the fields
    	| Fname | Lname | Email| Address| PhNum|
      | Yashwanth |     kumar | yashwanth121294@gmail.com| Taramani|9750866606|
      |Saravana	|Kumar	|sgpsaravana@gmail.com|Taramani|9952505294| 
      | Mathan |     kumar | mathanplayboy@gmail.com| Chennai|8608665717|
      | Yogesh |     legend | yogeshlegend@gmail.com| Madurai|7708024231|
    And The user submit the button
    Then The Customer id generated

 