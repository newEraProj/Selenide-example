@Sprint1
@TC_367
Feature: AC_238 patient eGFR might be calculated with Bedside Schwartz Formula

  Scenario Outline: TC_367 calculation of eGFR value with Betside Schwartz formula
    Given Log with my "test" credentials
    And  Open the eGFR calculation from a patient procedure and
    When Select the Bedside Schwartz Formula
    And Set the height to <Height>, the serum value to <Serum value> and click on result
    Then The eGFR result is <result>

    Examples:
      | Height | Serum value | result        |
      | 150 cm | 1,99 mg/dL  | 30.9 ,1.73 m2 |
      | 210 cm | 0.92        | 93.5 ,1.73 m2 |
      | 6,4ft  | 105.9       | 66.8 ,1.73 m2 |
