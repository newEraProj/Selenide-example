@Epic_495
@US_1574
@TC_2760
Feature:  AC_1762 The injection history data block shall display the list of previous stored procedures for the related patient.

  Background:
    Given Log with "admin" IAM login
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
      | patientId | accessNumber | datetime       | procedureType         | procedureName   | physician   | note    | status  |
      | T001      | A0001        | TODAY-1D_15:00 | CT Head with contrast | PROCEDURE X45K1 | Dr Jacobsen | Nothing | planned |
    And Following products exist
      | code       | concentrationUnit | concentrationValue | container | family     | name    | type     | validityDate | volume |
      | 6768420006 | mmol/mL           | 100                | syringe   | Gadolinium | OPTIRAY | contrast | 2020-01-01   | 125    |
      | Iodine1234 | mg/mL             | 250                | syringe   | Iodine     | Iodine  | contrast | 2020-01-01   | 125    |


  Scenario:  TC_2760 The injection history data block shall display the list of previous stored procedures for the related patient.
    Given Log with my "test" credentials

    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0001"
    And Add Examination product "6768420006" on patient procedure
    And Add a manual injection with volume "20" mL on patient procedure
    Then Product "6768420006" should be added on patient procedure
    And The manual injection with volume "20" mL should be added on patient procedure
    When Close the procedure "A0001" on patient procedure

    Given Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType          | procedureName      | physician   | note    | status  |
      | T001      | A0002        | TODAY_18:10 | CT Spine with contrast | PROCEDURE X45K12_3 | Dr Jacobsen | Nothing | planned |
    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0002"
    Then The injection with procedure modality "CT Head with contrast" and date "TODAY-1D_15:00" and product "6768420006" and volume "20" "mg" should be shown in the injection history on patient procedure
    When Click on the details of an examination in the injection history
    Then The pdf download of examination "CT Spine with contrast" in the injection history should be enabled
    When Add Examination product "Iodine1234" on patient procedure
    And Add a manual injection with volume "30" mL on patient procedure
    Then Product "Iodine1234" should be added on patient procedure
    And The manual injection with volume "30" mL should be added on patient procedure
    When Close the procedure "A0002" on patient procedure
    Given Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType          | procedureName       | physician   | note    | status  |
      | T001      | A0003        | TODAY_18:20 | CT Spine with contrast | PROCEDURE X45K12_3b | Dr Jacobsen | Nothing | planned |
    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0002"
    Then The injection with procedure modality "CT Head with contrast" and date "TODAY-1D_15:00" and product "6768420006" and volume "10" "mmol" should be shown in the injection history on patient procedure
    Then The injection with procedure modality "CT Spine with contrast" and date "TODAY_18:10" and product "Iodine1234" and volume "7500" "mg" should be shown in the injection history on patient procedure
    When Click on the details of an examination "CT Head with contrast" in the injection history
    Then The pdf download of examination "CT Head with contrast" in the injection history should be enabled
    Then The pdf download of examination "CT Spine with contrast" in the injection history should be enabled
