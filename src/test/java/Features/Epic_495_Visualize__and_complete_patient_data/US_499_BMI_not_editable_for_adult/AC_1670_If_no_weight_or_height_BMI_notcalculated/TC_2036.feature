@Epic_495
@US_578
@TC_2036
Feature:  AC_1670 If there is no weight or height the system must not calculate the BMI

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName  | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | mary      | Strassen  | 2000-01-01 | female |        |        | false     | unknown       |
      | T002      | Cecile    | Colli     | 1991-11-01 | female | 80     |        | false     | unknown       |
      | T003      | Georges   | Maeder    | 1968-03-01 | male   |        | 172    | false     | unknown       |
      | T004      | Philippe  | Beautemps | 1955-12-01 | male   | 120    | 190    | false     | unknown       |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0001        | TODAY_08:00 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T002      | A0002        | TODAY_09:00 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T003      | A0003        | TODAY_10:00 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T004      | A0004        | TODAY_11:00 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_2036 If there is no weight or height the BMI the system must not be calculated
    Given Log with my "test" credentials

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    Then BMI should not be available on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0002" on worklist
    Then BMI should not be available on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0003" on worklist
    Then BMI should not be available on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0004" on worklist
    Then BMI should not be available on patient procedure
    When Update the weight to "" on patient procedure
    Then BMI should not be available on patient procedure
    When Update the weight to "80" on patient procedure
    And  Update the height to "" on patient procedure
    Then BMI should not be available on patient procedure

