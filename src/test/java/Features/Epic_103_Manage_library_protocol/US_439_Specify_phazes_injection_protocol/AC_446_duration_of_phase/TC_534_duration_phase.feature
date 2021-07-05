@Epic_103
@US_380
@TC_534
Feature: AC_446 The system must calculate the duration of each phase (integer in second) if Phase type is different of Wait or Pause

  Background:
    Given Log with "test" IAM login
    And Database is empty

  Scenario: TC_534 The system must calculate the duration of each phase
    Given Log with my "test" credentials

    And   Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Click add new protocol on protocol management screen
    And   Add phase on protocol creation modal
    When  Set the type of phase to Injection on protocol creation modal
    Then  The duration field should be empty on protocol creation modal

    When Set flowrate to "5.3" on protocol creation modal
    Then  The duration field should be empty on protocol creation modal

    When Set volume to "25" on protocol creation modal
    Then  The duration field should be "5" on protocol creation modal

    When     Set flowrate to "0" on protocol creation modal
    Then  The duration field should be empty on protocol creation modal

    And     Set flowrate to "0.1" on protocol creation modal
    When    Set volume to "0" on protocol creation modal
    Then   The duration field should be "0" on protocol creation modal
