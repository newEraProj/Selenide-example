@Epic_495
@US_632
@TC_940
Feature: AC_818 The system shall let the user select whether the patient is breastfeeding

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Banane    | Chocolat | 1949-09-30 | female | 66.77  | 172    | false     | false         |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | Testra T74    | false   |
    And Following procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0005        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_940 The system shall let the user select whether the patient is breastfeeding
    Given Log with my "test" credentials
    Given Go to the worklist
    Given Select the station "Testra T74" on worklist
    And  Open the patient procedure "A0005" on worklist
    Then The pregnancy status should be "No" on patient procedure
    When Set the breastfeeding status at "Yes" on patient procedure
    Then A feedback message is displaying
    And The breastfeeding status should be "Yes" on patient procedure
    When Set the breastfeeding status at "No" on patient procedure
    Then A feedback message is displaying
    And The breastfeeding status should be "No" on patient procedure


