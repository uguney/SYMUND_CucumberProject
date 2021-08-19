@SYMU-435-login
Feature: Login functionality

	# User Story :
	# As a user, I should be able to login.

	# Acceptance Criteria:

	# 1-User can login with valid credentials
	# 2-User can not login with any invalid credentials
	# 3-User can see the password in a form of dots by default
	# 4-User can see the password explicitly if needed
	# 5-User can see an option link like "forgot password" on the login page to be able to reset the password
	# 6-User can see valid placeholders on Username and Password fields

  @SYMU-434
  Scenario: 6.Verify that user can see valid placeholders on Username and Password fields
    Given the user is on the login page
    Then "Username or email" should be seen on Username inputbox
    Then "Password" should be seen on Password inputbox

  @SYMU-433
  Scenario: 5.Verify that user can see link "Forgot password?" on the login page
    Given the user is on the login page
    Then the user should be able to see link "Forgot password?"
    When the user clicks on the Forgot password? link
    Then Reset password button should be seen on the next screen


  @SYMU-432
  Scenario: 4.Verify that user can see the password explicitly if needed
    Given the user is on the login page
    When the user enters user information
    And the user clicks on the eye icon
    Then the user should be able to see the password "Employee123" explicitly


  @SYMU-431
  Scenario: 3.Verify that user can see the password in a form of dots by default
    Given the user is on the login page
    When the user enters user information
    Then the user should be able to see the password in a form of dots by default

  @SYMU-430_3     #for leaving password blank
  Scenario: 2.Verify that user can not with invalid credentials
    Given the user is on the login page
    When the user logs in with "username" and ""
    Then the user should see "Please fill out this field." in username password


  @SYMU-430_2     #for leaving username blank
  Scenario: 2.Verify that user can not with invalid credentials
    Given the user is on the login page
    When the user logs in with "" and "password"
    Then the user should see "Please fill out this field." in username inputbox


  @SYMU-430_1
  Scenario Outline: 2.Verify that user can not with invalid credentials
    Given the user is on the login page
    When the user enters following credentials
      | username | <user>     |
      | password | <password> |

    Then the user should not be able to login
    Examples:
      | user    | password     |
      | user123 | password123  |
      | user00  | password0003 |

  @SYMU-429_1
  Scenario: Verify that user should be able to login by pressing "Enter" key
    Given the user is on the login page
    And the user enters user information
    And the user presses Enter key
    Then the user should be able to login
    And Username "uguney" should be seen under Profile icon

  @SYMU-429
  Scenario: 1.Verify that user can login with valid credentials
    Given the user is on the login page
    When the user logs in with user information
    Then the user should be able to login

