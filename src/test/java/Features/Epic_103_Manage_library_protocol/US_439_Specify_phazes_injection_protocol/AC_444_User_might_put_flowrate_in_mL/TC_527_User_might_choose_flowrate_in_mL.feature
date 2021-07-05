@Epic_103
@US_380
@TC_527
Feature: AC_444 User might input the flowrate in mL/s

  Background:
    Given Log with "test" IAM login
    And Database is empty

  Scenario: TC_527 User might input the flowrate in mL/s
    Given Log with my "test" credentials

    And   Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Click add new protocol on protocol management screen
    And   Add phase on protocol creation modal
    When  Set the type of phase to Injection on protocol creation modal

    And  Set flowrate to "6.5" on protocol creation modal
    When Click on protocol creation modal
    Then the flowrate value is presented and should be "6.5"

    And  Set flowrate to "18.559" on protocol creation modal
    When Click on protocol creation modal
    Then the flowrate value is presented and should be "18.5"

    And  Set flowrate to "100.1" on protocol creation modal
    When Click on protocol creation modal
    Then The error message should be Value cannot exceed 100 on flowrate section on protocol creation modal

    And  Set flowrate to "0.09" on protocol creation modal
    When Click on protocol creation modal
    Then The error message should be Value cannot be lower than 0.1 on flowrate section on protocol creation modal
