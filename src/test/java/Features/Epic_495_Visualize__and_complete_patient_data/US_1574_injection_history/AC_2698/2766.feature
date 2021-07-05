@Epic_495
@US_1574
@TC_2766
Feature:  AC_2698 The system shall display an information message if the patient has no previous examinations in C&C

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities | lastEgfrValues | lastScrValues |
      | T001      | Philippe  | Strassen | 2006-01-01 | male   | 36.77  | 72     | unknown   | unknown       |                    |                |               |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0001        | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_2766 The system shall display an information message if the patient has no previous examinations in C&C
    Given Log with my "test" credentials

    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0001"
    Then The message "No previous injection" should be displayed in the injection history on patient procedure
