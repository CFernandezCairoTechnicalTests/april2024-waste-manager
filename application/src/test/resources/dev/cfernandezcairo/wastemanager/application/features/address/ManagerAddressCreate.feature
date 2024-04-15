@ManagerAddressCreate
Feature: Can I create new manager address?

  Scenario: Creating a new manager address
    Given I provide all required data to create a address
    Then A new address is created