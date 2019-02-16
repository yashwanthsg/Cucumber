#Author: Kumar

Feature:
	Scenario: To test the customer page
    Given The user telecom page
    And The user navigates to add customer page
    When The user filling the details
    |Yashwanth	|Kumar	|yashwanth121294@gmail.com	|taramani	|9750866606	|
    |Mathan	|Kumar	|mathanpalyboy@gmail.com	|taramani		|8608665717	|
    |Saravana	|Kumar	|sgpsaravana@gmail.com	|velachery	|9952505294	|
    |Yogesh		|Legend	|yogeshwaran@gmail.com	|Perungudi	|9751121294	|
    And The user submitss the form
    Then The customer id is generated
   



