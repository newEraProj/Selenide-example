@Sprint1
@TC_254
Feature: AC_253 User might select the Serum creatinine unit from a list

  Scenario: TC_254 User might select the Serum creatinine unit from a list|
    Given Log with my "test" credentials
    And  Open the EGFR calculation
    When   The field of Serum creatinine value is presented in two types
    Then  A list for the serum creatinine unit is available with mg/dL and umol/L in eGFR calculation page


