@Sprint3
@TC_550
Feature: AC_544 Equivalence unit display
  Scenario: TC_550 Equivalence unit display
    Given Log with my "test" credentials
    And   Go to the configuration
    And   Open clinical parameters
    And   Go to creatinine levels screen
    Then  Creatinine levels unit choice are "µmol/L","mg/dL"
    When  Set creatinine unit to "µmol/L"
    When  Set the creatinine levels to "50" - "80" - "100" - "110"
    Then  Creatinine levels equivalence are "0.56" - "0.9" - "1.13" - "1.24"
    When  Set creatinine unit to "mg/dL"
    When  Set the creatinine levels to "0.6" - "0.9" - "1.2" - "1.3"
    Then  Creatinine levels equivalence are "53.1" - "79.65" - "106.19" - "115.04"

