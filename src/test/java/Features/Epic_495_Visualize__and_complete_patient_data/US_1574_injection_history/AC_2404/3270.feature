@Epic_495
@US_1574
@TC_3270
Feature:  AC_2404 The injection history must display 5 examinations maximum

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Philippe  | Strassen | 2006-01-01 | male   | 36.77  | 72     | unknown   | unknown       |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
      | CTScan2 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
      | CTScan3 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
      | CTScan4 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
      | CTScan5 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
      | CTScan6 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames                                   | fromRis |
      | CT           | Pro Auto | CTScan1;CTScan2;CTScan3;CTScan4;CTScan5;CTScan6 | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0001        | TODAY_18:00 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following procedures exist for station "CTScan2"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0002        | TODAY_18:10 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following procedures exist for station "CTScan3"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0003        | TODAY_18:20 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following procedures exist for station "CTScan4"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0004        | TODAY_18:30 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following procedures exist for station "CTScan5"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0005        | TODAY_18:40 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following procedures exist for station "CTScan6"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0006        | TODAY_18:50 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following procedures exist for station "CTScan6"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0007        | TODAY_19:00 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following products exist
      | code       | concentrationUnit | concentrationValue | container | family     | name       | type     | validityDate | volume |
      | 6768420006 | mg/mL             | 7                  | syringe   | barium     | Vibratrana | contrast | 2020-01-01   | 125    |
      | M52864GF   | mg/mL             | 50                 | syringe   | perflutren | Ibrutracin | contrast | 2020-06-0    | 100    |


  Scenario:  TC_1270 The injection history must display 5 examinations maximum
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
    And Select the station "CTScan2"
    And Open the patient procedure "A0002"
    And Add Examination product "6768420006" on patient procedure
    And Add a manual injection with volume "10" mL on patient procedure
    Then Product "6768420006" should be added on patient procedure
    And The manual injection with volume "10" mL should be added on patient procedure
    When Close the procedure "A0002" on patient procedure

    When Go to the worklist
    And Select the station "CTScan3"
    And Open the patient procedure "A0003"
    And Add Examination product "6768420006" on patient procedure
    And Add a manual injection with volume "10" mL on patient procedure
    Then Product "6768420006" should be added on patient procedure
    And The manual injection with volume "10" mL should be added on patient procedure
    When Close the procedure "A0003" on patient procedure

    When Go to the worklist
    And Select the station "CTScan4"
    And Open the patient procedure "A0004"
    And Add Examination product "6768420006" on patient procedure
    And Add a manual injection with volume "10" mL on patient procedure
    Then Product "6768420006" should be added on patient procedure
    And The manual injection with volume "10" mL should be added on patient procedure
    When Close the procedure "A0004" on patient procedure

    When Go to the worklist
    And Select the station "CTScan5"
    And Open the patient procedure "A0005"
    And Add Examination product "6768420006" on patient procedure
    And Add a manual injection with volume "10" mL on patient procedure
    Then Product "6768420006" should be added on patient procedure
    And The manual injection with volume "10" mL should be added on patient procedure
    When Close the procedure "A0005" on patient procedure

    When Go to the worklist
    And Select the station "CTScan6"
    And Open the patient procedure "A0006"
    Then "5" previous injections should be shown in the injection history on patient procedure
    And Add Examination product "6768420006" on patient procedure
    And Add a manual injection with volume "10" mL on patient procedure
    Then Product "6768420006" should be added on patient procedure
    And The manual injection with volume "10" mL should be added on patient procedure
    When Close the procedure "A0006" on patient procedure

    When Go to the worklist
    And Select the station "CTScan6"
    And Open the patient procedure "A0007"
    Then "5" previous injections should be shown in the injection history on patient procedure
    And A button to see the previous injection should be visible
