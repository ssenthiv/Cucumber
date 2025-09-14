

@LoginTest
Feature: login functionality for demoQA.com
	
Background:
		Given An user is on DemoQA.com 
    When user clicks on MyAccountLink 
	
	@LoginTest1
  Scenario: Verify that user is able to successfully login using a valid username and password
    
    Then user is taken to Login Page
    When user enters a valid username shun and password pass123
    Then User is able to login successfully
	@LoginTest2
  Scenario: Login with Invalid username
    # Pre condition
    Given user is taken to Login Page
    # Interaction with the App
    When user enters a invalid username and password
		# Verification
    Then Application should deny login to the user

# And will be implemented using @When
  @LoginTest3
  Scenario: Verify that user is able to successfully login using a valid username and password
   # Given An user navigate to FreeCRM.com
   # When user clicks on MyAccountLink
    And user enters a valid username Senthiv and password wrongpass
    Then User is able to login successfully
