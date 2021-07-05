@Epic_103
@US_380
@TC_547
Feature: AC_453 If the user change the type of phase to Pause, the other fields are reset and disabled (except duration)

  Background:
    Given Log with "test" IAM login
    And Database is empty

  Scenario: TC_547  If the user change the type of phase to Pause, the other fields (except duration) are reset and disabled
    Given Log with my "test" credentials


    And   Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Click add new protocol on protocol management screen
    And   Add phase on protocol creation modal
    And   Set the type of phase to Injection on protocol creation modal
    And   Set product to "c+s" on the phase on protocol creation modal
    And   Set flowrate to "6.5" on protocol creation modal
    And   Set volume to "24.22" on protocol creation modal
    And   Set contrast rate to "20" on phase on protocol creation modal
    When  Set the type of phase to Pause on phase on protocol creation modal

    Then  The fields product, flowrate, volume, contrast and duration should be reset on phase on protocol creation modal
    Then  The fields product, flowrate, volume and contrast should be disabled
    Then  The duration should be enabled on phase on protocol creation modal
