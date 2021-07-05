@Epic_495
@US_1574
@TC_2762
Feature:  AC_1758 The system shall display the modality type of the procedures in an examination and differentiate the MR procedures

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
      | patientId | accessNumber | datetime       | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0001        | TODAY-1D_15:00 | CT Head       | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T001      | A0002        | TODAY_18:10    | PET           | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T001      | A0003        | TODAY_18:20    | MR            | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T001      | A0004        | TODAY_18:30    | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following products exist
      | code       | concentrationUnit | concentrationValue | container | family     | name       | type     | validityDate | volume |
      | 6768420006 | mg/mL             | 7                  | syringe   | barium     | Vibratrana | contrast | 2020-01-01   | 125    |
      | M52864GF   | mg/mL             | 50                 | syringe   | perflutren | Ibrutracin | contrast | 2020-06-0    | 100    |


  Scenario:  TC_2762 The system shall display the modality type of the procedures in an examination and differentiate the MR procedures
    Given Log with my "test" credentials

    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0001"
    And Add Examination product "6768420006" on patient procedure
    And Add a manual injection with volume "10" mL on patient procedure
    Then Product "6768420006" should be added on patient procedure
    And The manual injection with volume "10" mL should be added on patient procedure
    When Close the procedure "A0001" on patient procedure

    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0002"
    And Add Examination product "6768420006" on patient procedure
    And Add a manual injection with volume "20" mL on patient procedure
    Then Product "6768420006" should be added on patient procedure
    And The manual injection with volume "20" mL should be added on patient procedure
    When Close the procedure "A0002" on patient procedure

    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0003"
    And Add Examination product "6768420006" on patient procedure
    And Add a manual injection with volume "30" mL on patient procedure
    Then Product "6768420006" should be added on patient procedure
    And The manual injection with volume "30" mL should be added on patient procedure
    When Close the procedure "A0003" on patient procedure

    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0004"
    Then "3" previous injections should be shown in the injection history on patient procedure
    Then The modality type should be displayed in the injection history on patient procedure
    Then The injection with procedure modality MR should differentiate from other procedures in the injection history on patient procedure
