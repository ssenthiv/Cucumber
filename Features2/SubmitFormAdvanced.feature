#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@ValidFormTest
Feature: Submit Form with valid data
  I want to use this template for my feature file

	
	
	
	
  @ValidFormTest1
  Scenario: Submit form with valid data
  
    Given User opens http://integr8a.trclient.com Page
    When User fills the form with correct data
    	|FirstName 					|Shunmugasundaram 	|
    	|LastName 					|  				|
    	|Email   						|ssenthiv@gmail.com | 
    	|MobileNo     			|   9890064244 			|
    	|Address      			| A703 SkyLark 			|
    	|Suburb    					| Bangalore 				|
    	|State 							| ACT   						|
    	|PostCode 					|  5667 						|
    	|Dob        				|  26/02/1977 			|
    	|TermsAndCondition 	|  Y      					|
    	|Submit 						| Y      				  	|
    	    
    Then I verify the Form not submitted

	@ValidFormTest2
  Scenario: Submit form with Multiple valid data
    Given User launches http://integr8a.trclient.com Page
    When  User submit the form with multiple correct data and verify form
     | FirstName        | LastName   | Email                        | MobileNo     | Address      | Suburb    | State | PostCode | Dob        | TermsAndCondition | Submit |
     | Shunmugasundaram | Senthivelu | ssenthiv@gmail.com           |   9890064244 | A703 SkyLark |  | ACT   |     5667 | 26/02/1977 | Y                 | Y      |
     | SURESH KUMAR     |     | firstName.Lastname@yahoo.com | 918778787878 | A703 SkyLark | Chennai   |   SA  |     6217 | 10/07/1985 | Y                 | Y      |
		#Then I verify the Form not submitted
	
	@ValidFormTest3
  Scenario Template: Submit form with Multiple valid data using Scenario Outline
    Given User launches http://integr8a.trclient.com Page
    When User Enters data for Scenario Template FirstName <FirstName>  LastName <LastName> Email  <Email> MobileNo  <MobileNo>   Address  <Address> Suburb  <Suburb> State  <State> PostCode  <PostCode> Dob  <Dob> TermsAndCondition  <TermsAndCondition> Submitn  <Submit> button
    Then  I verify the Form not submitted

    Examples: 
     | FirstName        | LastName   | Email                        | MobileNo     | Address      | Suburb    | State | PostCode | Dob        | TermsAndCondition | Submit |
     | Shunmugasundaram | Senthivelu | ssenthiv@gmail.com           |   9890064244 | A703 SkyLark | Bangalore | ACT   |     5667 | 26/02/1977 | Y                 |       |
     | SURESH KUMAR     | MANLANI    | firstName.Lastname@yahoo.com | 918778787878 | A703 SkyLark | Chennai   | SA    |     6217 | 10/07/1985 | N                 | Y      |

  
	
