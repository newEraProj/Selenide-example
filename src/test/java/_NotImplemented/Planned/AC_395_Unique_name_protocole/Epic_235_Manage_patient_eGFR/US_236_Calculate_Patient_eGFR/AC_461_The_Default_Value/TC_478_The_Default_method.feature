@Sprint1
@TC_478
Feature: AC_461 If there is no default method set to compute eGFR's value, the default method is CKD-EPI

  Scenario: TC_478 The default value
    Given Log with my "test" credentials
    And   Open the eGFR calculation modal from a patient procedure
    When  The formula set is CKD-EPI and the serum creatinine unit is mg/dL. African American / serum value / serum date
    And   Set the MDRD formula
    Then  The serum creatinine unit is mg/dL. African American and IDMS aren't set



