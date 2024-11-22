Feature: Google Search

  @google
  Scenario Outline: I want to search a keyword on Google Home page
    Given I am on google home page
    When I enter "<keyword>" as a keyword
    Then I should see at least <count> results

    Examples:
    |       keyword      |     count     |
    |      java          |      2        |
    |      selenium      |      5        |
    |      spring boot   |      3        |