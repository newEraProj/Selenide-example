@Epic_495
@US_1862
@TC_2163
Feature: AC_1944 User must be able to uncheck the Id of a patient
  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Philippe  | Strassen | 2006-01-01 | male   | 36.77  | 72     | unknown   | unknown       |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0001        | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_2163 User must be able to uncheck the Id of a patient
    Given Log with my "test" credentials
    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0001"
    Then The patient identity should be "unchecked" on patient procedure
    When Set the patient identity to "checked" on patient procedure
    Then The patient identity should be "checked" on patient procedure
    When Set the patient identity to "unchecked" on patient procedure
    Then The patient identity should be "unchecked" on patient procedure
