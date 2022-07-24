
Feature: Product Detail functionality


  Scenario Outline: Click buy it now button in product detail
    Given user is on ebay.com page
    And user enters "<text>" in searchbar box
    And click search
    When click "<x>" product
    And click BuyItButton
    Then sea popup check

    Examples:
      | text | x |
      | iphone | 1 |


  Scenario Outline: Click buy it now button in product detail
    Given user is on ebay.com page
    And user enters "<text>" in searchbar box
    And click search
    When click "<x>" product
    And "<pieces>" pieces of order
    Then sea quantity error

    Examples:
      | text | x |pieces |
      | tv | 3 | 0 |

