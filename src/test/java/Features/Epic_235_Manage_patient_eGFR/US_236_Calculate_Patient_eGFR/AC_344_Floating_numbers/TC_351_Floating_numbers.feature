@Sprint1
@TC_351
Feature: AC_344 Input data which are float must have to respect the specified number of decimals, rounded down

  Scenario: TC_351 Input data which are float must have to respect the specified number of decimals, rounded down
    Given Log with my "test" credentials
    And Open the eGFR calculation form from a patient procedure
    When  Set the Cockcroft-Gault formula and Serum value to 101.5999 umol/L
    Then  The serum creatinine value have been rounded to 101,59

