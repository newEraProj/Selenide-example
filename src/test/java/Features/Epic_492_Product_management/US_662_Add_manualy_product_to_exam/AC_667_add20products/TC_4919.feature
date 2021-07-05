@Epic_492
@US_667
@TC_4919
Feature: AC_667 User must be able to add up to 20 products to an examination

  Background:
    Given Log with "test" IAM login
    And Database is empty

    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Philippe  | Strassen | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | gsonInjectors                                                 |
      | CTScan1 | CT           | PHILIPS      | Y12   | false         | false               | false             | true               | [{"model": "FlowSens","name": "FlowSens K25","idcId": "k25"}] |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0001        | TODAY_12:06 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following products exist
      | code       | concentrationUnit | concentrationValue | container | family     | name       | type     | validityDate | volume |
      | 6768420006 | mg/mL             | 7                  | syringe   | barium     | Vibratrana | contrast | 2020-01-01   | 125    |
      | M52864GF   | mg/mL             | 50                 | syringe   | perflutren | Ibrutracin | contrast | 2020-06-06    | 100    |

  Scenario: TC_4919 User must be able to entry the lot number and the expiration date
    Given Log with my "test" credentials

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    When Add Examination product "6768420006" on patient procedure
    Then product "6768420006" should have no expiration date and no lot number on patient procedure

    When Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add Examination product "6768420006" on patient procedure

    Then No toast error message should be displayed
    When Add Examination product "6768420006" on patient procedure
    Then A toast error message "There cannot be more than 20 products" should be displayed

