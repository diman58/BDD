Feature: filter

  Background:
    Given indexpage of app is opened
    When user type in Username standard_user
    And user type in Password secret_sauce
    And user click LOGIN

  Scenario Outline: filter all possible ways
    When user filter <order>
    Then items are filtered in <expectedOrder>

    Examples:
      | order               | expectedOrder       |
      | Name (A to Z)       | Name (A to Z)       |
      | Name (Z to A)       | Name (Z to A)       |
      | Price (low to high) | Price (low to high) |
      | Price (high to low) | Price (high to low) |



