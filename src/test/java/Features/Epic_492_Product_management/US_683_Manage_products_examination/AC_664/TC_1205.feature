@Epic_492
@US_683
@TC_1205
Feature:  AC_664 User must be able to delete a product attached to an examination

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities | lastEgfrValues | lastScrValues |
      | TC_1205_1 | Paul      | Dupont   | 1969-09-30 | male   | 86.5   | 172    | unknown   | No            |                    |                |               |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter |  injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |             |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | TC_1205_1 | A0001        | TODAY_18:21          | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following products exist
      | code          | concentrationUnit | concentrationValue | container | family | name    | type     | validityDate | volume |
      | 3400933776275 | mg/mL             | 250                | Vial      | Iodine | Xenetix | Contrast | 2022-01-01   | 100    |
      | 3400933776237 | mg/mL             | 300                | Vial      | Iodine | Xenetix | Contrast | 2022-01-01   | 50     |

  Scenario: TC_1205 User must be able to delete a product attached to an examination
    Given Log with my "test" credentials
    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Add Examination product "3400933776275" on patient procedure
    Then No toast error message should be displayed
    And The examination product "3400933776275" should be added to procedure "A0001" on patient procedure
    When Delete Examination product "3400933776275" with expiration date = "" and lot number = "" on patient procedure
    Then No toast error message should be displayed
    And The examination product "3400933776275" should not be visible on patient procedure
    