@Epic_76
@US_77
@TC_292
Feature: AC_92 Number of entries displayed might be selectable

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | true          | true                | true              | true               |
    And Following "100" procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | AN_          | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_292 User shall have option to select displayed entries
    Given Log with my "test" credentials
    And   Go to the worklist
    And   Select the station "Testra T74"
    And   Set "10" entries per page
    When  There are max "10" procedures per page screened
    Then  Set "25" entries per page
    And   There are max "25" procedures per page screened
    When  Set "50" entries per page
    And   There are max "50" procedures per page screened
    Then  Set "100" entries per page
    And   There are max "100" procedures per page screened

