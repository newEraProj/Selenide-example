@Sprint3
@TC_571
Feature: AC_530 An user might discard all changes
  Scenario:TC_571 An user might discard all changes
    Given Log with my "test" credentials
    Given Go to the configuration
    And   Open clinical parameters
    And   Go to creatinine levels screen
    And    Set creatinine unit to "µmol/L"
    When   Set the creatinine levels to "50" - "80" - "100" - "110"
    And    Set validity period for creatinine "20"
    And    Save creatinine levels
    And    Set creatinine unit to "mg/dL"
    When   Set the creatinine levels to "0.67" - "0.95" - "1.7" - "2.5"
    When   Discard all creatinine level changes
    Then   Creatinine levels are 50 - 80 - 100 - 110
    And    Creatinine levels unit choice are "µmol/L","mg/dL"
