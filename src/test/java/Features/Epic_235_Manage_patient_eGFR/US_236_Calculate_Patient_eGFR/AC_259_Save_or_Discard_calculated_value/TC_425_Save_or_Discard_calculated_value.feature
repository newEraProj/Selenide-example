@Epic_235
@US_236
@TC_425
Feature: AC_259 User must be able to save or discard the calculated value in the patient information

  Background:
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Banane    | Chocolat | 1949-09-30 | male   | 65     | 175    | unknown   | false         |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | true          | true                | true              | true               |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | Testra T74    | false   |
    And Following procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0005        | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |


  Scenario: TC_425 User must be able to save or discard the calculated value in the patient information
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

    And    Select the "Bedside-Schwartz" formula
    When   Set up age to "60" years on clearance calculation module
    When   Set up gender to "female" on clearance calculation module
    When   Set up Race to "yes" on clearance calculation module
    When   Set up Serum unit to "µmol/L" on clearance calculation module
    When   Set up Serum value to "78.5" on clearance calculation module
    When   Set up Test date to "" on clearance calculation module
    When   Set up IDMS value to "no" on clearance calculation module
    When   Set up Height to "177" on clearance calculation module
    When   Click on Cancel button on clearance settings screen
    Then   The Serum result isnt saved

    And    Select the "Cockroft-Gault" formula
    When   Set up age to "22" years on clearance calculation module
    When   Set up Gender to "male" on clearance calculation module
    When   Set up Race to "yes" on clearance calculation module
    When   Set up Serum unit to "µmol/L" on clearance calculation module
    When   Set up Serum value to "99.85" on clearance calculation module
    When   Set up Test date to ""  on clearance calculation module
    When   Set up IDMS value to "no"
    When   Set up Weight value to "69" on clearance calculation screen
    When   Click compute button on clearance calculation module
    When   Save the result on eGFR calculation screen

    Then   The serum result is saved





