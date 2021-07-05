@Epic_103
@US_380
@TC_538
Feature: AC_455 Percentage of contrast might have default value and might be not editable according to the product

  Background:
    Given Log with "test" IAM login
    And Database is empty

  Scenario: TC_538 Percentage of contrast might have default value and might be not editable
    Given Log with my "test" credentials

    And   Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Click add new protocol on protocol management screen
    And   Add phase on protocol creation modal

    And   Set the type of phase to Injection on protocol creation modal
    And   Set product to "saline" on the phase on protocol creation modal
    Then  The field Contrast rate should be "0" and not editable

    When  Set product to "contrast" on the phase on protocol creation modal
    Then  The field Contrast rate should be "100" and not editable

