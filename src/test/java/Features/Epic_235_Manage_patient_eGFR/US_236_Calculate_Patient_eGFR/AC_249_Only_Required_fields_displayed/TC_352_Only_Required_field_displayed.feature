@Sprint1
@TC_352
Feature: AC_249 Only required fields for the formula must be displayed

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
      | T001      | A0005        | 2020-02-06T10:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_352 Only required fields for the formula must be displayed
    Given Log with my "test" credentials
    And   Go to the worklist
    And   Select the station "Testra T74"
    And   Open the patient procedure "A0005"
    And   Open the eGFR manual calculation from the patient procedure
    When  Select the "CKD-EPI" formula
    Then  Serum creatinine unit and value fields are presented on clearance calculation module
    Then  Age should be displayed on clearance calculation module
    Then  Gender should be displayed on clearance calculation module
    Then  African American field should be displayed on clearance calculation module
    When Select the "MDRD" formula
    Then Serum creatinine unit and value fields should be displayed on clearance calculation module
    Then Age should be displayed on clearance calculation module
    Then Gender should be displayed on clearance calculation module
    Then African American field should be displayed on clearance calculation module
    Then IDMS field should be displayed on clearance calculation module
    When Select the "Bedside Schwartz" formula
    Then Serum creatinine unit and value fields should be displayed on clearance calculation module
    Then Height should be displayed on clearance calculation module

    When Select the "Cockroft-Gault" formula
    Then Serum creatinine unit and value fields should be displayed on clearance calculation module
    Then Age should be displayed on clearance calculation module
    Then Weight should be displayed on clearance calculation module
    Then Gender should be  displayed on clearance calculation module





