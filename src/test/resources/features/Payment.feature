@UITest
Feature: Payment

  @Payment
  Scenario Outline: Order a product
    Given User launched eshop login page
    When User logged in eshop using the valid emailid "<EmailID>" and the valid password "<Password>"
    And User searches for the "<Product>"
    And User should be able to view and add the product "<Product>"
    And User Address details with "<Title>","<FirstName>", "<LastName>", "<Line1>","<Line2>","<City>","<State>", "<Zipcode>"
    And User Payment details with "<CardNumber>", "<CardName>", "<Year>","<Month>","<SecurityCode>"
    Then User should get the Confirmation of Order

    Examples:
      | EmailID               | Password  | Product               | Title | FirstName | LastName | Line1        | Line2         | City   | State       | Zipcode | CardNumber       | CardName | Year | Month | SecurityCode |
      | john.doe@cts-shop.com | password-1 | Apple iPhone 6s Plus | Mr    | John     | Doe      | Queen Garden | Victoria Road | London | Lanarkshire  | G50UH    | 1111111111111111 | John    | 2025 | 12    | 232          |
