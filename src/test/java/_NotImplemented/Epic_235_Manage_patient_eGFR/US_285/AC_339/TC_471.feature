@Sprint3
@TC_471
Feature: AC_339

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities | lastEgfrValues | lastScrValues |
      | T001      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | Testra T74    | false   |
    And Following procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0005        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario:TC_471
    Given Log with my "test" credentials
    And Go to the configuration
    When   Open eGFR levels screen
    When   Set the eGFR value levels to "30","60","90"
    When   Save eGFR levels
    When   Go to creatinine levels screen
    When   Set the creatinine levels to "1" - "2" - "3" - "4"
    When   Set validity period for creatinine "20"
    When   Save creatinine levels
    When   Go to the worklist
    And    Select the station "Testra T74"
    And    Open the patient procedure "A0005"
    When   Open the eGFR manual calculation from the patient procedure
    When   Select the Bedside Schwartz formula
    When   Set the height to "170"
    When   Set serum unit to "µmol/L"
    When   Set serum value "40.99"
    When   Set serum date "D-31"
    And   Click compute eGFR value
    And   Save the result on eGFR calculation screen
    When   Open the eGFR manual calculation from the patient procedure
    When   Select the CKD-EPI formula
    When   Set African-American to "yes"
    When   Set serum unit to "mg/dL"
    When   Set serum value "2.57"
    When   Set serum date "D-20"
    And   Click compute eGFR value
    And   Save the result on eGFR calculation screen
    When   Open the eGFR manual calculation from the patient procedure
    When   Select the MDRD formula
    When   Set African-American to "yes"
    When   Set IDSM to "No"
    When   Set serum unit to "mg/dL"
    When   Set serum value "1.4"
    When   Set serum date "D-10"
    And  Click compute eGFR value
    And   Save the result on eGFR calculation screen

    Then  The first one is Value = "30.1 mL/minute/1.73 m2"  colored in "yellow"
    Then  The second one is Value = "76.4 mL/minute/1.73 m2" colored in "orange"
    Then  The third one is  Value = "150.1 mL/minute/1.73 m2"  colored in "grey"




