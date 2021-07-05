@Epic_103
@US_380
@TC_536

Feature: AC_450 User might choose the percentage of contrast if Product=C+S

  Background:
    Given Log with "test" IAM login
    And Database is empty

  Scenario: TC_536  User might choose the percentage of contrast if Product=C+S
    Given Log with my "test" credentials

    And   Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Click add new protocol on protocol management screen
    And   Add phase on protocol creation modal
    And   Set the type of phase to Injection on protocol creation modal
    And   Set product to "c+s" on the phase on protocol creation modal

    Then  The folowing percentage of contrast:20,30,40,50,60,70,80 should be availible on protocol creation modal
