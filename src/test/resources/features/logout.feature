@SYMU-438-logout
Feature: Logout Functionality

	#User Story :

	#As a user, I should be able to log out.

	#Acceptance Criteria:

	#1-User can log out and ends up in login page
	#2-User can not go to home page again by clicking step back button after successfully logged out.

	Background:
		Given the user is on the login page
		When the user logs in with user information

	@SYMU-437
	Scenario: 2.Verify that user can not go to home page again by clicking step back button after successfully logged out.

		    And the user clicks on user profile icon
		    And the user clicks on Log out option
		    When the user clicks on the GO BACK button
		    Then the user should not be able to login again

	@SYMU-436
	Scenario: 1.Verify that user can log out and ends up in login page

		    And the user clicks on user profile icon
		    And the user clicks on Log out option
		    Then Login page should be loaded again
		