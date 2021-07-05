@Epic_495
@US_499
@TC_4735
Feature:  AC_689 BMI is not available for child

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Cecile    | Strassen | TODAY-15Y | female | 67.99  | 172    | false     | unknown       |
      | T002      | Mary      | Strassen | TODAY-50Y | female | 69.33  | 172    | false     | unknown       |
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

  Scenario: TC_4735 BMI is not available for child
    Given Log with my "test" credentials

    When Go to the configuration
    And  Open other clinical parameters
    And  Set pediatric age to "17" years on other clinical parameters
    And  Save modification on other clinical parameters
    Then The pediatric age should be "17" years on other clinical parameters


    When Go to the worklist
    And  Select the station "CTScan1" on worklist
    And  Open the patient procedure "A0001" on worklist
    Then BMI should not be available on patient procedure
    And  A message should be displayed "BMI is not applicable" on patient procedure

