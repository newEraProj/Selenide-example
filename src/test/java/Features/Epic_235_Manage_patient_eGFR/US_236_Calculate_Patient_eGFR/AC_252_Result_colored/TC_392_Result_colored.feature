@Epic_235
@US_236
@TC_392
Feature: AC_252 the result shall be colored according to eGFR's level

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
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0005        | TODAY_18:21          | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
  Scenario: TC_392 the result shall be colored according to eGFR's level
    Given Log with my "test" credentials

    And    Go to the configuration
    And    Open clearance settings screen
    And    Set the eGFR value levels to "30","60","90"
    When   Set creatinine unit to "µmol/L"
    When   Set the creatinine levels to "30" - "50" - "70" - "100"
    When   Set validity period for creatinine "365"
    And    Save creatinine levels


    And   Go to the worklist
    And   Select the station "Testra T74"
    And   Open clearance calculation module

    When   Select the "CKD-EPI" formula
    When   Set Age to "65" years on clearance calculation module
    When   Set Gender to "male" on clearance calculation module
    When   Set Race to "yes" on clearance calculation module
    When   Set Serum unit to "mg/dL" on clearance calculation module
    When   Set Serum value to "2.51" on clearance calculation module
    When   Set Test date to "" on clearance calculation module
    When   Click compute button on clearance calculation module

    Then   eGFR color should be "red" on clearance calculation module
    Then   eGFR result should be "29.0" on clearance calculation module

    When   Select the "MDRD" formula
    When   Set Age to "60" years on clearance calculation module
    When   Set Gender to "female" on clearance calculation module
    When   Set Race to "yes" on clearance calculation module
    When   Set Serum unit to "µmol/L" on clearance calculation module
    When   Set Serum value to "104.52" on clearance calculation module
    When   Set Test date to "" on clearance calculation module
    When   Set IDMS value to "no" on clearance calculation module
    When   Click compute button on clearance calculation module

    Then   eGFR color should be "orange" on clearance calculation module
    Then   eGFR result should be "59.9" on clearance calculation module

    When   Select the "Bedside-Schwartz" formula
    When   Set Age to "60" years on clearance calculation module
    When   Set Gender to "female" on clearance calculation module
    When   Set Race to "yes" on clearance calculation module
    When   Set Serum unit to "µmol/L" on clearance calculation module
    When   Set Serum value to "78.5" on clearance calculation module
    When   Set Test date to "" on clearance calculation module
    When   Set IDMS value to "no" on clearance calculation module
    When   Set Height to "172" on clearance calculation module
    When   Click compute button on clearance calculation module


    Then   eGFR color should be "yellow" on clearance calculation module
    Then   eGFR result should be "60.1" on clearance calculation module

    When   Select the "Cockroft-Gault" formula
    When   Set Age to "22" years on clearance calculation module
    When   Set Gender to "male" on clearance calculation module
    When   Set Race to "yes" on clearance calculation module
    When   Set Serum unit to "µmol/L" on clearance calculation module
    When   Set Serum value to "99.85" on clearance calculation module
    When   Set Test date to ""  on clearance calculation module
    When   Set IDMS value to "no" on clearance calculation module
    When   Set Weight value to "62" on clearance calculation module
    When   Click compute button on clearance calculation module

    Then   eGFR color should be "green" on clearance calculation module
    Then   eGFR result should be "90.1" on clearance calculation module







