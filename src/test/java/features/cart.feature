Feature: cart

  Background:
    Given indexpage of app is opened
    When user type in Username standard_user
    And user type in Password secret_sauce
    And user click LOGIN

    Scenario: cart click
      * user click Cart