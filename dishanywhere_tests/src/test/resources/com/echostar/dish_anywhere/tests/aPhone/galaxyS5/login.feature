Feature: The app allows the user to log out and log in.

  Scenario: The user logs out and back in again.
    Given the application is in a clean state
    And the application is on the on the guide
    When the user clicks settings
    And the user clicks logs out
    And the user logs in
    Then the application should be logged in