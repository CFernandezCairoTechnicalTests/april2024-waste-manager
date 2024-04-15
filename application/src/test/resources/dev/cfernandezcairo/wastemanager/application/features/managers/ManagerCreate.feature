@ManagerCreate
Feature: Can I create new manager?

  Scenario: Creating a new manager
    Given I provide all required data to create a manager
    Then A new manager is created