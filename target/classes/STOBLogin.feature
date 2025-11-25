Feature: Smart tech online banking login function check 

As a registered user, I can login with valid credentials. Login should be successful and I should see the logout button. 
Otherwise, login should fail and show an error message.

Background:
  Given Open any browser
  And Pass URL

  @Positive @STOB-10
  Scenario: Login with valid credentials 
    When Enter valid username 
    And Enter valid password
    And Click login button
    Then Login should be successful and see logout button 

  @Negative @STOB-11
  Scenario: Login with invalid credentials 
    When Enter invalid username 
    And Enter invalid password
    And Click login button
    Then Login should fail and stay on login page

  @Negative @STOB-12
  Scenario: Login with invalid username and valid password  
    When Enter invalid username 
    And Enter valid password
    And Click login button
    Then Login should fail and stay on login page

  @Negative @STOB-13
  Scenario: Login with valid username and invalid password  
    When Enter valid username 
    And Enter invalid password
    And Click login button
    Then Login should fail and stay on login page

  @Negative @STOB-14
  Scenario: Login with empty username and password  
    When Enter empty username 
    And Enter empty password
    And Click login button
    Then Login should fail and stay on login page
   
  @Negative @STOB-15
  Scenario: Login with empty username and valid password  
    When Enter empty username 
    And Enter valid password
    And Click login button
    Then Login should fail and stay on login page

  @Negative @STOB-16
  Scenario: Login with valid username and empty password  
    When Enter valid username 
    And Enter empty password
    And Click login button
    Then Login should fail and stay on login page
