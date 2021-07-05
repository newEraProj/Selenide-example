@Epic_103
@US_380
@TC_528
Feature: AC_445 User might input the volume to inject (float in mL)

  Background:
    Given Log with "test" IAM login
    And Database is empty

  Scenario: TC_528 User might input the volume to inject (float in mL)
    Given Log with my "test" credentials

    And   Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Click add new protocol on protocol management screen
    And   Add phase on protocol creation modal
    When  Set the type of phase to Injection on protocol creation modal

    And  Set volume to "24.22" on protocol creation modal
    When Click on protocol creation modal
    Then The volume value is presented and equals to"24" with unit mL on protocol creation modal

    And  Set volume to "24.229" on protocol creation modal
    When Click on protocol creation modal
    Then The volume value is presented and equals to"24" with unit mL on protocol creation modal
