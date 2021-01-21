@UITest
Feature: Login

  Scenario Outline: E-Shop Application - Create New Account
    Given User launched eshop login page
    When User create account with "<FirstName>", "<LastName>", "<EmailID>" and "<Password>"
    Then User account should get created

    Examples:
      | FirstName | LastName | EmailID           | Password  |
      | test      | user     | testuser@shop.com | Testing$1 |

  #Scenario Outline: Login to the E-Shop Application
  #  Given User launched eshop login page in "Web"
  #  When User logged in eshop using the valid emailid "<EmailID>" and the valid password "<Password>"
  #  Then user should see a shop home page

  #  Examples:
  #    | EmailID               | Password  |
  #    | john.doe@cts-shop.com | password-1 |

  Scenario Outline: Login to the E-Shop Application with Wrong Password
    Given User launched eshop login page
    When User logged in eshop using the invalid emailid "<EmailID>" and the invalid password "<Password>"
    Then User should not get logged in

    Examples:
      | EmailID                    | Password   |
      | testuser_negative@shop.com | password-1 |