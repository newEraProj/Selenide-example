@Epic_492
@US_662
@TC_1224
Feature: AC_665 User must be able to entry the lot number and the expiration date

  Background:
    Given Log with "test" IAM login
    And Database is empty

    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Philippe  | Strassen | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |
      | T002      | Marc      | Boiffort | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |
      | T003      | Franck    | dubourg  | 2009-09-30 | male   | 66.77  | 172    | unknown   | unknown       |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0001        | TODAY_12:06 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T002      | A0002        | TODAY_12:06 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following products exist
      | code       | concentrationUnit | concentrationValue | container | family     | name       | type     | validityDate | volume |
      | 6768420006 | mg/mL             | 7                  | syringe   | barium     | Vibratrana | contrast | 2020-01-01   | 125    |
      | M52864GF   | mg/mL             | 50                 | syringe   | perflutren | Ibrutracin | contrast | 2020-06-0    | 100    |
    And Following products exist for procedure "A0001"
      | code       | concentrationUnit | concentrationValue | container | family     | name       | type     | validityDate | volume | addedMethod |
      | 6768420006 | mg/mL             | 7                  | syringe   | barium     | Vibratrana | contrast | 2020-01-01   | 125    | manually    |
      | M52864GF   | mg/mL             | 50                 | syringe   | perflutren | Ibrutracin | contrast | 2020-06-0    | 100    | manually    |

  Scenario: TC_1224 User must be able to entry the lot number and the expiration date
    Given Log with my "test" credentials

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    Then product "6768420006" should have no expiration date and no lot number on patient procedure
    When Close the examination tab on worklist
    Then The tab of the opened procedure should be closed
    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Update examination product "M52864GF" with expiration date = "TODAY+2D" and lot number = "ceciestuntestpourlataill1ceciestuntestpourlataill2ceciestuntestpourlataill3ceciestuntestpourlataill4" on patient procedure
    Then The examination product "M52864GF" should be added to procedure "A0001" on patient procedure
    When Go to the worklist
    When Close the examination tab on worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Update examination product "M52864GF" with lot number = "ceciestuntestpourlataill1ceciestuntestpourlataill2ceciestuntestpourlataill3ceciestuntestpourlataill42" on patient procedure
    Then The examination product "M52864GF" should be added to procedure "A0001" on patient procedure
    And  The examination product "M52864GF" lot number = "ceciestuntestpourlataill1ceciestuntestpourlataill2ceciestuntestpourlataill3ceciestuntestpourlataill4" should be displayed to procedure "A0001" on patient procedure

