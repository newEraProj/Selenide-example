@Epic_103
@US_380
@TC_548
Feature: AC_474 User might enter the duration if phase type is Pause

  Background:
    Given Log with "test" IAM login
    And Database is empty

  Scenario: TC_548 User might enter the duration if phase type is Pause
    Given Log with my "test" credentials

    And   Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Click add new protocol on protocol management screen
    And   Add phase on protocol creation modal
    And   Set the type of phase to Pause on phase on protocol creation modal

    When  Set duration on phase to "5.5"on protocol creation modal
    Then  The error message is screened on pause phase should be duration is an integer

    When  Set duration on phase to "900"on protocol creation modal
    Then  The error message is screened on pause phase should be exceeded maximum duration

    When  Set duration on phase to "-1"on protocol creation modal
    Then  The error message is screened on pause phase should be cannot be less than 1
