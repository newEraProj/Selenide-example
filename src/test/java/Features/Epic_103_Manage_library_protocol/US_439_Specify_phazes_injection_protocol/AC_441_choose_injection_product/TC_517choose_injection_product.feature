@Epic_103
@US_380
@TC_517
Feature: AC_441 User might choose the type of the injection product for each phase
  Background:
    Given Log with "test" IAM login
   And Database is empty
  Scenario: TC_517 User might choose the type of the injection product for each phase
    Given Log with my "test" credentials
    And   Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Click add new protocol on protocol management screen

    And   Add phase on protocol creation modal
    Then  There is no default value for product type in the phase on protocol creation modal
    When  Set the type of phase to Injection on protocol creation modal
    And   Click on product on phase on protocol creation modal
    Then  Product should have following values: "Contrast,Saline,C+S" on phase on protocol creation modal
