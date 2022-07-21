
Feature: Check searchbar functionality


  Scenario Outline: Validate searchbar is working
    Given user is on ebay.com page
    When user enters <text> in searchbar box
    And click search
    Then user is navigated to search results

    Examples:
      | text |
      | iphone |
