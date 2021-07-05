@Epic_492
@US_662
@TC_1223
Feature: AC_663 User must be able to select a product from the product library

  Background:
    Given Log with "test" IAM login
    And Database is empty

    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Philippe  | Strassen | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |
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
      | code          | concentrationUnit | concentrationValue | container | family | name                         | type     | validityDate | volume |
      | 3400933776275 | mg/mL             | 250                | Vial      | Iodine | Xenetix                      | Contrast | 2022-01-01   | 100    |
      | 3400933776237 | mg/mL             | 300                | Vial      | Iodine | Xenetix                      | Contrast | 2022-01-01   | 50     |
      | 3400933776238 | mg/mL             | 300                | Vial      | Iodine | Xenetix                      | Contrast | 2022-01-01   | 20     |
      | 3400933776539 | mg/mL             | 250                | Vial      | Iodine | Xenetix                      | Contrast | 2022-01-01   | 50     |
      | 3400933276645 | mg/mL             | 300                | Vial      | Iodine | Optiray                      | Contrast | 2022-01-01   | 50     |
      | 3400955109587 | mg/mL             | 9                  | Bag       | Saline | Chlorure de sodium Fresenius | Saline   | 2022-01-01   | 250    |

  Scenario: TC_1223 User must be able to select a product from the product library
    Given Log with my "test" credentials

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Set "3" in search product on patient procedure
    Then No suggestion is proposed in search product on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Set "3400" in search product on patient procedure
    Then Product list is displayed in search product on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Set "3400933" in search product on patient procedure
    Then Suggestion "3400933776275 - Xenetix - Contrast - Iodine - Vial - 250 mg/mL - 100mL" should be displayed in search product on patient procedure
    Then Suggestion "3400933776237 - Xenetix - Contrast - Iodine - Vial - 300 mg/mL - 50mL" should be displayed in search product on patient procedure
    Then Suggestion "3400933776238 - Xenetix - Contrast - Iodine - Vial - 300 mg/mL - 20mL" should be displayed in search product on patient procedure
    Then Suggestion "3400933776539 - Xenetix - Contrast - Iodine - Vial - 250 mg/mL - 50mL" should be displayed in search product on patient procedure
    Then Suggestion "3400933276645 - Optiray - Contrast - Iodine - Vial - 300 mg/mL - 50mL" should be displayed in search product on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Set "34009337762" in search product on patient procedure
    Then Suggestion "3400933776275 - Xenetix - Contrast - Iodine - Vial - 250 mg/mL - 100mL" should be displayed in search product on patient procedure
    Then Suggestion "3400933776237 - Xenetix - Contrast - Iodine - Vial - 300 mg/mL - 50mL" should be displayed in search product on patient procedure
    Then Suggestion "3400933776238 - Xenetix - Contrast - Iodine - Vial - 300 mg/mL - 20mL" should be displayed in search product on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Set "Xene" in search product on patient procedure
    And Set selection "3400933776275 - Xenetix - Contrast - Iodine - Vial - 250 mg/mL - 100mL" in search product on patient procedure
    Then Product "3400933776275 - Xenetix - Contrast - Iodine - Vial - 250 mg/mL - 100mL" should be added on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Set "Xene" in search product on patient procedure
    Then Suggestion "3400933776275 - Xenetix - Contrast - Iodine - Vial - 250 mg/mL - 100mL" should be displayed in search product on patient procedure
    Then Suggestion "3400933776237 - Xenetix - Contrast - Iodine - Vial - 300 mg/mL - 50mL" should be displayed in search product on patient procedure
    Then Suggestion "3400933776238 - Xenetix - Contrast - Iodine - Vial - 300 mg/mL - 20mL" should be displayed in search product on patient procedure
    Then Suggestion "3400933776539 - Xenetix - Contrast - Iodine - Vial - 250 mg/mL - 50mL" should be displayed in search product on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    And Set "Xene" in search product on patient procedure
    And Set selection "3400933776275 - Xenetix - Contrast - Iodine - Vial - 250 mg/mL - 100mL" in search product on patient procedure
    Then Products "3400933776275 - Xenetix - Contrast - Iodine - Vial - 250mg/mL - 100mL" and "3400933776237 - Xenetix - Contrast - Iodine - Vial - 300 mg/mL - 50mL" should be linked on patient procedure

