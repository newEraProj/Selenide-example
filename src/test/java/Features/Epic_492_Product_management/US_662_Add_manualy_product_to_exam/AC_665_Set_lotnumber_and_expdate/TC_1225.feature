@Epic_492
@US_662
@TC_1225
Feature: AC_665 User must be able to entry the lot number and the expiration date

  Background:
    Given Log with "test" IAM login
    And Database is empty

    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities | lastEgfrValues | lastScrValues |
      | T001      | Philippe  | Strassen | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
      | T002      | Marc      | Boiffort | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
      | T003      | Franck    | dubourg  | 2009-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
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
      | code       | concentrationUnit | concentrationValue | container | family | name       | type     | validityDate | volume |
      | 6768420006 | mg/mL             | 7                  | syringe   | barium | Vibratrana | contrast | 2020-01-01   | 125    |
    And Following products exist for procedure "A0001"
      | code | concentrationUnit | concentrationValue | container | family | name | type | validityDate | volume | addedMethod |

  Scenario: TC_1224 User must be able to entry the lot number and the expiration date
    Given Log with my "test" credentials

    When Go to the configuration
    And Go to Product management
    And Go to Recall management
    And Add a recall product "6768420006" with lot number "1" on Recall management screen
    And Click save recall product
    Then The product "6768420006" with lot number "1" should be displayed on Recall management screen
    When Go to the configuration
    And Go to Product management
    And Go to product library
    And Add product "1234" with drug name "Drug1" and type "contrast" family "barium" container "syringe" concentration "12" and volume of "120" with validity date "TODAY" on product library
    And Add product "5678" with drug name "Drug2" and type "saline" family "gadolinium" container "bag" concentration "14" and volume of "140" with validity date "TODAY-1D" on product library
    And Add product "9101" with drug name "Drug3" and type "contrast" family "iodine" container "vial" concentration "16" and volume of "160" with validity date "TODAY+1D" on product library
    Then The product "1234" should be displayed on product library
    Then The product "5678" should be displayed on product library
    Then The product "9101" should be displayed on product library

    When Go to the worklist
    And Open the patient procedure "A0001" on worklist
    Then product "6768420006" should have no expiration date and no lot number on patient procedure
    When Close the examination tab on worklist
    Then The tab of the opened procedure should be closed
    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Add Examination product "9101" on patient procedure
    Then The examination product "9101" lot number = "" should be displayed to procedure "A0001" on patient procedure
    And Add Examination product "1234" with expiration date = "" and lot number = "ceciestuntestpourlataill1ceciestuntestpourlataill2ceciestuntestpourlataill3ceciestuntestpourlataill4" on patient procedure
    Then The examination product "1234" lot number = "ceciestuntestpourlataill1ceciestuntestpourlataill2ceciestuntestpourlataill3ceciestuntestpourlataill4" should be displayed to procedure "A0001" on patient procedure
    When Update examination product "M52864GF" with expiration date = "TODAY+2M" and lot number = "ceciestuntestpourlataill1ceciestuntestpourlataill2ceciestuntestpourlataill3ceciestuntestpourlataill42" on patient procedure
    Then The examination product "1234" lot number = "ceciestuntestpourlataill1ceciestuntestpourlataill2ceciestuntestpourlataill3ceciestuntestpourlataill4" should be displayed to procedure "A0001" on patient procedure

    When Add Examination product "6768420006" with expiration date = "TODAY+5M" and lot number = "" on patient procedure
    Then An alert "Recall" is shown for Examination product "6768420006" on patient procedure
    When Delete Examination product "6768420006" with expiration date = "TODAY+5M" and lot number = "" on patient procedure
    And  Add Examination product "1234" with expiration date = "TODAY+5M" and lot number = "" on patient procedure
    Then An alert "non-authorized" is shown for Examination product "1234" on patient procedure

    When Delete Examination product "1234" with expiration date = "TODAY+5M" and lot number = "" on patient procedure
    And  Add Examination product "5678" with expiration date = "TODAY+5M" and lot number = "" on patient procedure
    Then An alert "non-authorized" is shown for Examination product "5678" on patient procedure

    When Delete Examination product "5678" with expiration date = "TODAY+5M" and lot number = "" on patient procedure
    And  Add Examination product "9101" with expiration date = "TODAY+5M" and lot number = "" on patient procedure
    Then An alert "non-authorized" is shown for Examination product "9101" on patient procedure

    When Update examination product "9101" with expiration date = "TODAY+1M" and lot number = "" on patient procedure
    Then An alert "expired" is shown for Examination product "9101" on patient procedure

    When Update examination product "9101" with expiration date = "TODAY-1M" and lot number = "" on patient procedure
    Then An alert "expired" is shown for Examination product "9101" on patient procedure
