Feature: Ebay. Change language, search for items, filter search, open found, add to cart.

  Scenario: Change Language
    Given I open language selector
    When I select "English"
    Then Selected language is applied

  Scenario Outline: Search for item
    Given I search for "<query>"
    When I push Search button
    Then Found element 3 contains "<query>"
    Examples:
      |query    |
      |ASUS     |
      |Samsung  |

  Scenario: Filter found items using Buy It Now
    Given I search for "ASUS"
    And I push Search button
    When I use filter Buy It Now
    Then Found items don't contain "ставк"

  Scenario: Open found item
    Given I search for "ASUS"
    And I push Search button
    When I open found item "2"
    Then Selected item is opened

  Scenario: Add item to the cart
    Given I search for "ASUS"
    And I push Search button
    And I filter Buy It Now
    And I open found item "1"
    When I add item to cart
    Then Page "Cart" is opened
    And Item is in cart





    