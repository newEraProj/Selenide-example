@Epic_492
@US_682
@TC_1226
Feature:  AC_682 The user might enter the same product several times to an examination.

  Background:
    Given Log with "admin" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities | lastEgfrValues | lastScrValues |
      | T001      | Philippe  | Strassen | 1969-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0001        | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following products exist
      | code          | concentrationUnit | concentrationValue | container | family | name    | type     | validityDate | volume |
      | 3400933776275 | mg/mL             | 250                | Vial      | Iodine | Xenetix | Contrast | 2022-01-01   | 100    |
      | 3400933776237 | mg/mL             | 300                | Vial      | Iodine | Xenetix | Contrast | 2022-01-01   | 50     |

  Scenario: TC_1226 The system must only display the worklist associated to the selected station
    Given Log with my "admin" credentials
    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Add Examination product "3400933776275" on patient procedure
    Then No toast error message should be displayed
    When Add Examination product "3400933776275" on patient procedure
    Then No toast error message should be displayed
    When Add Examination product "3400933776275" on patient procedure
    Then No toast error message should be displayed
    When Close the examination tab on worklist
    And Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    Then Examination product "3400933776275" should be present 3 times on patient procedure
