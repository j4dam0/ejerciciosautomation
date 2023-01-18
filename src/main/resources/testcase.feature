Feature: is element present in cart

  Scenario: element is present
    Given element is present
    When i assert if element is present
    Then i should return true

 Scenario:  element is not present
   Given element is not present
   When i assert if element is present
   Then i should return false