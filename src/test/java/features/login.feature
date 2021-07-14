Feature: login


  Scenario Outline: login
    Given indexpage of app is opened
    When user type in Username <login>
    And user type in Password <password>
    And user click LOGIN
    Then homepage of app is opened

    Examples:
      | login                   | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
