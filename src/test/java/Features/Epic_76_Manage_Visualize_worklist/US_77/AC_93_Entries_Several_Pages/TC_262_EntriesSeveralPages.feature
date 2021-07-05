@Epic_76
@US_77
@TC_262
Feature: AC_93 Entries might be displayed on several pages

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities |
      | T001      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |                    |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | true          | true                | true              | true               |
    And Following "25" procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | AN_          | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_262 Worklist entries should be screened on several pages
    Given Log with my "test" credentials
    When   Go to the worklist
    And    Select the station "Testra T74"
    And    Set "10" entries per page
    Then   Not more than "10" entries should be screened
    When   Click on the next page button
    Then   Not more than "10" entries should be screened
    When   Click on the next page button
    Then   Not more than "5" entries should be screened


