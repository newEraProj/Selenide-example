@Epic_495
@US_499
@TC_1216
Feature:  AC_578 BMI is not available for child

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | mary      | Strassen | 2000-11-01 | female | 66.77  | 172    | false     | unknown       |
      | T002      | Cecile    | Colli    | 2001-11-01 | female | 66.77  | 172    | true      | unknown       |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0001        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T002      | A0002        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_1216 If pregnancy status is True or changed to True BMI is not available
    Given Log with my "test" credentials

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    Then BMI should be available on patient procedure
    When Set the pregnancy status at "Yes" on patient procedure
    Then BMI should not be applicable on patient procedure
    When Close the patient procedure tab "A0001" on worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0002" on worklist
    Then BMI should not be applicable on patient procedure
    When Set the pregnancy status at "No" on patient procedure
    Then BMI should be available on patient procedure

