Feature: Add found item to cart.

  Scenario: Add item to cart
    Given I search for "ASUS"
    And I filter Buy It Now
    And I open found item "1"
    When I add item to cart
#    Then Page "cart" is opened
    Then Item is in cart





    