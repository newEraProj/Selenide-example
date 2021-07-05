@Sprint1
@TC_337
Feature: AC_238 MDRD_Formula

  Scenario Outline: TC_337 calculating of eGFR value with MDRD formula
    Given Log with my "test" credentials
    And  Open the eGFR calculations from a patient procedure
    When Select the MDRD Formula
    And Set age to "<Age>" Age, "<Gender>"  Gender, "<Afro American>" Afro American , "<IDMS>"  IDMS  , "<Serum value>"  Serum value
    Then The eGFR result is "<result>"
    Examples:
      | Age | Gender | Afro American | IDMS | Serum value | result |
      | 39  | male   | No            | No   | 0.86        | 105.2  |
      | 39  | female | No            | No   | 0.86        | 78.0   |
      | 58  | male   | Yes           | Yes  | 0.86        | 94.4   |
      | 58  | male   | Yes           | Yes  | 89.53       | 88.8   |