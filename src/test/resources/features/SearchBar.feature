
Feature: Check searchbar functionality


  Scenario Outline: Validate searchbar is correct working (with text)
    Given user is on ebay.com page
    When user enters "<text>" in searchbar box
    And click search
    Then user is navigated to "<resultText>" search results

    Examples:
      | text | resultText |
      | iphone | iphone |
      | samsung | samsung |

  Scenario Outline: Validate searchbar is correct working (empty)
    Given user is on ebay.com page
    When user enters "<text>" in searchbar box
    And click search
    Then user is navigated to "<page>"

    Examples:
      | text | page |
      |  | https://www.ebay.com/n/all-categories |

