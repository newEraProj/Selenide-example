@Epic_495
@US_1574
@TC_2764
Feature:  AC_1761 The injection history must display the details of the past examination

  Background:
    Given Log with "admin" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Philippe  | Strassen | 2006-01-01 | male   | 36.77  | 72     | unknown   | unknown       |
      | T002      | Corinne   | Sallanc  | 1980-01-01 | female | 80.3   | 70     | no        | no            |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name               | stationsNames | fromRis |
      | Head         | Head with contrast | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType         | procedureName | physician   | note    | status  |
      | T001      | A0001        | TODAY_15:00 | CT Head with contrast | Pro Auto      | Dr Jacobsen | Nothing | planned |
      | T001      | A0011        | TODAY_17:00 | CT Head with contrast | Pro Auto      | Dr Jacobsen | Nothing | planned |
      | T002      | A0002        | TODAY_16:00 | CT Head with contrast | Pro Auto      | Dr Jacobsen | Nothing | planned |
    And Following products exist
      | code       | concentrationUnit | concentrationValue | container | family     | name                | type     | validityDate | volume |
      | Xenetix250 | mg/mL             | 250                | vial      | gadolinium | Xenetix             | contrast | 2030-01-01   | 125    |
      | serumphy01 |                   |                    | vial      | saline     | Chrlorure de Sodium | saline   | 2030-01-01   | 125    |
      | dotarem0.5 | mmol/mL           | 0.5                | vial      | barium     | DOTAREM             | contrast | 2030-01-01   | 125    |


  Scenario:  TC_2761 The injection history must display the details of the past examination
    Given Log with my "test" credentials

    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0001"
    And Add Examination product "Xenetix250" on patient procedure
    And Add Examination product "serumphy01" on patient procedure
    Then Product "Xenetix250" should be added on patient procedure
    And Product "serumphy01" should be added on patient procedure
    When Click on add injector results manually on patient procedure
    And Set injector name = "FlowSens 21" in add injector results manually modal on patient procedure
    And Set a phase type = "injection" product = "contrast" flowrate = "5" mL/s volume = "25" mL in add injector results manually modal on patient procedure
    And Add a new phase in add injector results manually modal on patient procedure
    And Set a phase type = "injection" product = "saline" flowrate = "2" mL/s volume = "30" mL in add injector results manually modal on patient procedure
    And Add a new phase in add injector results manually modal on patient procedure
    And Set a phase type = "injection" product = "contrast" flowrate = "6" mL/s and volume = "10" mL in add injector results manually modal on patient procedure
    And Save the injection in add injector results manually modal on patient procedure
    Then A injection with injector result added manually with "3" phases should be shown on patient procedure
    When Set link to procedure "A0011" on patient procedure
    Then The procedure "A0011" should be linked on patient procedure
    When Close the procedure "A0001" on patient procedure
    Then The procedure "A0001" is closed on patient procedure

    Given Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType         | procedureName      | physician   | note    | status  |
      | T001      | A0012        | TODAY_18:40 | CT Head with contrast | PROCEDURE X45K12_3 | Dr Jacobsen | Nothing | planned |
    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0012"
    Then The injection with procedure modality "CT Head with contrast" and date "TODAY_15:00" and product "Xenetix250" and volume "8750" "mg" should be shown in the injection history on patient procedure
    Then The procedure named "A0001" should be visible in the injection history on patient procedure
    Then The procedure named "A0011" should be visible in the injection history on patient procedure
    Then The total injected volume should be "35" mL in the injection history on patient procedure
    And Add Examination product "dotarem0.5" on patient procedure
    And Add Examination product "serumphy01" on patient procedure
    Then Product "dotarem0.5" should be added on patient procedure
    And Product "serumphy01" should be added on patient procedure
    When Click on add injector results manually on patient procedure
    And Set injector name = "FlowSens 21" in add injector results manually modal on patient procedure
    And Set a phase type = "injection" product = "contrast" flowrate = "5" mL/s volume = "20" mL in add injector results manually modal on patient procedure
    And Add a new phase in add injector results manually modal on patient procedure
    And Set a phase type = "injection" product = "saline" flowrate = "2" mL/s volume = "30" mL in add injector results manually modal on patient procedure
    And Add a new phase in add injector results manually modal on patient procedure
    And Set a phase type = "injection" product = "contrast" flowrate = "6" mL/s and volume = "10" mL in add injector results manually modal on patient procedure
    And Save the injection in add injector results manually modal on patient procedure
    When Close the procedure "A0001" on patient procedure
    Then The procedure "A0001" is closed on patient procedure

    Given Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType         | procedureName      | physician   | note    | status  |
      | T001      | A0013        | TODAY_18:50 | CT Head with contrast | PROCEDURE X45K12_3 | Dr Jacobsen | Nothing | planned |
    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0013"
    Then The procedure named should be "A0012" with date "TODAY_18:40" in the injection history on patient procedure
    Then The product "Gadolinium" with injected quantity "15" "mmol" should be shown in the injection history on patient procedure
    Then The product "Dotarem" with concentration "0.5" unit "mmol/mL" should be shown in the injection history on patient procedure
    Then The total injected volume should be "30" mL in the injection history on patient procedure