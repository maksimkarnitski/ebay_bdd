Feature: Search for items, filter search, open found.

  Scenario Outline: Search for item
    When I search for "<query>"
    Then Found element "1" contains "<query>"

    Examples:
      |query    |
      |ASUS     |
      |Samsung  |

  Scenario: Filter found items using Buy It Now
    Given I search for "ASUS"
    When I use filter Buy It Now
    Then Found items don't contain "ставк"

  Scenario: Open found item
    Given I search for "ASUS"
    When I open found item "2"
    Then Selected item is opened




    