@UITest
Feature: Search and Add

  @Search
  Scenario Outline: Search and Add Product
    Given User launched eshop login page
    When User logged in eshop using the valid emailid "<EmailID>" and the valid password "<Password>"
    And User searches for the "<Product>"
    Then User should be able to view and add the product "<Product>"

    Examples:
      | EmailID               | Password   | Product                       |
      | testuser@cts-shop.com | password-1 | Apple iPhone 6s Plus          |