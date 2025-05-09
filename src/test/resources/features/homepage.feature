Feature: Autocomplete search on Amazon

  Scenario: Valid search term shows suggestions
    Given I am on the Amazon homepage
    When I type "celular" in the search bar
    Then I should see autocomplete suggestions
    
  Scenario: Invalid search of term
  	Given I am on the Amazon homepage
  	When I type "hsjapqçkdahuwqiajklsa" in the search bar
  	Then I should not see autocomplete suggestions
  	
  Scenario: Show menu in max resolution
  	Given I am on the Amazon homepage
  	When I maximize browser
  	Then I should see many items on menu
  	
  Scenario: Show menu in mobile resolution
  	Given I am on the Amazon homepage
  	When I put browser in a mobile resolution
  	Then I should be able to use burger menu
  	
  Scenario: Click on item on mobile resolution
  	Given I am on the Amazon homepage
  	When I put browser in a mobile resolution
  	And I open burger menu
  	When I click on Novidades na Amazon on menu
  	Then I should be redirected to Amazon new releases
  	
  Scenario: Page should load fast
  	Given I am on the Amazon homepage
  	Then loading time should be lass than 3000
  	