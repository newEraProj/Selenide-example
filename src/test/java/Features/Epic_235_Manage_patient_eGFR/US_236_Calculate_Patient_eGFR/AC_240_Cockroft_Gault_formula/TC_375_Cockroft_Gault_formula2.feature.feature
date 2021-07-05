@Sprint1
@TC_375
Feature: AC_240 Patient eGFR might be calculated with Cockroft-Gault Formula

  Scenario Outline: TC_375 Patient eGFR might be calculated with Cockroft-Gault Formula
    Given Log with my "test" credentials
    And   Open calculation screen
    When  Select the Cockroft-Gault Formula in calculation screen
    And   Set the age to <years> years,<Gender> Gender , <weight> weight, serum value = <serum>,
    Then  The result is screened <result> mL/minute

    Examples:
      | years | weight | serum | result | Gender |
      | 38    | 65     | 2.69  | 34.2   | male   |
      | 38    | 80     | 2.69  | 42.1   | male   |
      | 85    | 80     | 2.69  | 22.7   | male   |
      | 85    | 80     | 26.6  | 204.2  | male   |
      | 85    | 80     | 26.5  | 172.6  | female |
      | 85    | 80     | 26.5  | 172.6  | other  |
