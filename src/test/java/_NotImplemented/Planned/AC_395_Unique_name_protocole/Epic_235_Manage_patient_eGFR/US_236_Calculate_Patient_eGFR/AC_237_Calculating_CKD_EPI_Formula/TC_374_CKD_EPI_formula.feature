@Sprint1
@TC_374
Feature: AC_237 Patient eGFR might be calculated with CKD-EPI formula

  Scenario Outline: TC_374 CKD-EPI formula should ne prestented to calculate egfr page
    Given Log with my "test" credentials
    And  Open the eGFR calculation from a patient procedure
    When Select the CKD-EPI formula
    And Set the Age to "<Age>" years, "<Gender>" Gender, "<Afro American>" Afro-American , "<Serum value>" Serum value ,
    Then The eGFR result is "<result>" result
    Examples:
      | Age | Gender | Afro American | Serum value | result |
      | 50  | Male   | Yes           | 2.01 mg/dL  | 43.5   |
      | 50  | Female | Yes           | 2.01 mg/dL  | 32.7   |
      | 50  | Female | No            | 2.01 mg/dL  | 28.2   |

