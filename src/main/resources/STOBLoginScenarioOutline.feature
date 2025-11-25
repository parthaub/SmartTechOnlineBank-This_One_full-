@Smoke @Functional @Regression
Feature: Smart tech online banking login function check

  As a registered user, I want to be able to log in with valid credentials.
  Login should be successful, and I should see the logout button.
  Otherwise, the login should fail, and I should see an error message.

  Background:
    Given Open any browser
    And Pass URL

  @Login
  Scenario Outline: Login with different combinations of username and password
    When Enter "<username>" in username field
    And Enter "<password>" in password field
    And Click login button
    Then Login should <result> and <nextStep>

    Examples:
      | username   | password        | result        | nextStep               |
      | Batch44    | student123@     | be successful | see logout button      |
      | tch44      | stunt123@       | fail          | stay on login page     |
      | tch44      | student123@     | fail          | stay on login page     |
      | Batch44    | stunt123@       | fail          | stay on login page     |
      |            |                 | fail          | stay on login page     |
      |            | student123@     | fail          | stay on login page     |
      | Batch44    |                 | fail          | stay on login page     |
