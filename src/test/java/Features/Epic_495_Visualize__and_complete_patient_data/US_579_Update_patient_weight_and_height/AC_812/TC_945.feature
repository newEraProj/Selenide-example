@Sprint3
@update_patient_weight_and_height
Feature: @AC_812 The user might update manually patient data information (weight and height)
  Scenario: @TC_945 The user might update manually patient data information (weight and height)

    Given Log with my "test" credentials
    And  Go to the examination of patient "EFG Fraise"
    Then The patient information is enabled on patient procedure
    And The patient weight should be displayed on patient procedure
    And The patient height should be displayed on patient procedure
    When Set the patient weight at "12.5" on patient procedure
    And Set the patient height at "156" on patient procedure
    Then The patient weight should be "12.5" on patient procedure
    And The patient height should be "156" on patient procedure

    Given Go to the examination of patient "EFG Fraise"
    Then The patient information is enabled on patient procedure
    And The patient weight should be "12.5" on patient procedure
    And The patient height should be "156" on patient procedure
