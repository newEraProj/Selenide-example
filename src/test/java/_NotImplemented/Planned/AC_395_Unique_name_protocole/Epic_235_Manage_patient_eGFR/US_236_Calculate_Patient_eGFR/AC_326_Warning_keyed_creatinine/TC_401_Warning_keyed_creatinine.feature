@Sprint1
@TC_401
Feature: AC_326 The system must display a warning if the keyed creatinine value is older than 90 days

  Scenario: TC_401 The system must display a warning if the keyed creatinine value is older than 90 days
    Given Log with my "test" credentials
    And Open the eGFR calculation from a patient worklist
    When Select the Bedside Schwartz formula, set the height to 195 cm, serum unit to umol/L, serum value to 89.9 and serum date to 91 days press compute
    Then A warning is displayed because the serum value is older than 90 days

