@Epic_495
@US_580
@TC_3544
Feature: AC_3072User must be able to specify that a patient has no hypersensitivity

  Background:
    Given Log with "test" IAM login
    And Database is empty

    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities | lastEgfrValues | lastScrValues |
      | T001      | Philippe  | Strassen | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
      | T002      | Marc      | Boiffort | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
      | T003      | Franck    | dubourg  | 2009-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0001        | TODAY_12:06          | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T002      | A0002        | TODAY_12:06          | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following products exist
      | code       | concentrationUnit | concentrationValue | container | family     | name       | type     | validityDate | volume |
      | 6768420006 | mg/mL             | 7                  | syringe   | barium     | Vibratrana | contrast | 2020-01-01   | 125    |

  Scenario: TC_3544 User must be able to specify that a patient has no hypersensitivity
    Given Log with my "test" credentials
    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    When Add Examination product "6768420006" on patient procedure
    Then The examination product "6768420006" should be added to procedure "A0001" on patient procedure
    When Add an hypersensitivity "barium" on patient procedure
    Then The hypersensitivities block displays hypersensitivity "barium" on patient procedure
    Then The declare none button in the hypersensitivity block should not be displayed on patient procedure
    When Remove from the hypersensitivity block the hypersensitivity "barium" on patient procedure
    Then The declare none button in the hypersensitivity block should be displayed on patient procedure
