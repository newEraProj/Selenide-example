@Epic_76
@US_77
@TC_233
Feature: AC_130 Display eGFR values

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |
      | T002      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |
      | T003      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |
      | T004      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |
      | T005      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |
      | T006      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |
      | T007      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |
      | T008      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |
      | T009      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |
    And Following last egfr values exist
      | patientId | clearanceLevel | methodName       | testDate    |
      | T001      | 75             | Bedside Schwartz | TODAY_18:21 |
      | T002      | 75             | Bedside Schwartz | TODAY_18:21 |
      | T003      | 29             | Bedside Schwartz | TODAY_18:21 |
      | T004      | 30             | Bedside Schwartz | TODAY_18:21 |
      | T005      | 59             | Bedside Schwartz | TODAY_18:21 |
      | T006      | 60             | Bedside Schwartz | TODAY_18:21 |
      | T007      | 89             | Bedside Schwartz | TODAY_18:21 |
      | T008      | 90             | Bedside Schwartz | TODAY_18:21 |
      | T009      | 91             | Bedside Schwartz | TODAY_18:21 |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | true          | true                | true              | true               |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | Testra T74    | false   |
    And Following procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | AN_1         | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T002      | AN_2         | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T003      | AN_3         | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T004      | AN_4         | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T005      | AN_5         | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T006      | AN_6         | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T007      | AN_7         | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T008      | AN_8         | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T009      | AN_9         | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_233 The eGFR value has to be displayed with its associated color
    Given Log with my "test" credentials
    And    Go to the worklist
    And    Go to the configuration
    And    Open clearance settings screen
    And    Set the eGFR value levels to "30","60","90"
    When   Set creatinine unit to "µmol/L"
    When   Set the creatinine levels to "30" - "50" - "70" - "100"
    When   Set validity period for creatinine "365"
    And    Save creatinine levels

    When   Go to the worklist
    And    Select the station "Testra T74"
    Then   The procudure "AN_1" should have "gray" eGFR result
    Then   The procudure "AN_2" should have "gray" eGFR result
    Then   The procudure "AN_3" should have "red" eGFR result
    Then   The procudure "AN_4" should have "red" eGFR result
    Then   The procudure "AN_5" should have "orange" eGFR result
    Then   The procudure "AN_6" should have "orange" eGFR result
    Then   The procudure "AN_7" should have "yellow" eGFR result
    Then   The procudure "AN_8" should have "yellow" eGFR result
    Then   The procudure "AN_9" should have "green" eGFR result

