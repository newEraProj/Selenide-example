@Epic_235
@US_236
@TC_410
Feature: AC_247 User must fill every fields to calcule the eGFR

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Banane    | Chocolat | 1949-09-30 | male   | 70     | 170    | unknown   | false         |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | true          | true                | true              | true               |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | Testra T74    | false   |
    And Following procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0005        | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_410 User must fill every fields to calcule the eGFR
    Given Log with my "test" credentials
    And    Go to the configuration
    And    Open clearance settings screen
    When   Set the eGFR value levels to "30","60","90"
    When   Set creatinine unit to "µmol/L"
    When   Set the creatinine levels to "30" - "50" - "70" - "100"
    When   Set validity period for creatinine "365"
    And    Save creatinine levels

    And   Go to the worklist
    When  Select the station "Testra T74"
    And   Open the patient procedure "A0005"
    And   Open the eGFR manual calculation from the patient procedure

    And   Select the Bedside Schwartz formula
    When  Set Height to "" on efgr calculation screen
    When  Click compute eGFR value
    Then  An error message should be displayed on the height

    And   Select the CKD-EPI formula
    When  Set Race field to "" on egfr calculation screen
    And   Click compute eGFR value
    Then  An error message should be displayed on the race
    When  Set serum date to "" on egfr calculation screen
    When  Click compute eGFR value
    Then  An error message should be displayed on the date
    When  Set serum value with unit mg/dl to "" on egfr calculation screen
    When  Click compute eGFR value
    Then  An error message should be displayed on the serum value

    And   Select the MDRD formula
    When  Set IDMS to "" on egfr calculation screen
    When  Click compute eGFR value
    Then  An error message should be displayed on the IDMS

    And   Select the Cockroft-Gault formula
    When  Set weight to "" on egfr calculation screen

    And   Select the "Bedside Schwartz" formula
    When  Set Height value to "" on clearance calculation module
    When  Click compute eGFR value
    Then  An error message should be displayed on the height

    And   Select the "CKD-EPI" formula
    When  Set Race to "" on clearance calculation module
    And   Click compute eGFR value
    Then  An error message should be displayed on the race
    When  Set Serum date to ""on clearance calculation module
    When  Click compute eGFR value
    Then  An error message should be displayed on the date
    When  Set Serum value to "" on clearance calculation module
    When  Click compute eGFR value
    Then  An error message should be displayed on the serum value

    And   Select the "MDRD" formula
    When  Set IDMS value to "" on clearance calculation module
    When  Click compute eGFR value
    Then  An error message should be displayed on the IDMS

    And   Select the "Cockroft-Gault" formula
    When  Set Weight value to "" on clearance calculation module
    When  Click compute eGFR value
    Then  An error message should be displayed on the height


