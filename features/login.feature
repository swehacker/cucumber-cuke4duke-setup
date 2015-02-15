Feature: Login
In order to have different prices and selection of products for customers
As a manager,
I want customers to be able to be uniquely identified so the customer can see products and prices specific for them.

Scenario: Login as a System administrator
	Given I am on the dk web site
	When I fill in "username" with "system"
	And I fill in "password" with "thriller1982"
 	And I press the button "submit"
	Then I should see the message "Logget på som system" 

Scenario: Wrong username and password
	Given I am on the dk web site
	When I fill in "username" with "wrong_username"
	And I fill in "password" with "wrong_password"
	And I press the button "submit"
	Then I should see the message "Brugernavn og/eller password matcher ingen bruger"