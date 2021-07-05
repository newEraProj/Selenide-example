@Epic_76
@US_77
@TC_261
Feature: AC_91 Each line from the worklist might be clickable to get to the Procedure page

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities |
      | T001      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |                    |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | true          | true                | true              | true               |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | Testra T74    | false   |
    And Following procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0005        | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_261 Each line from the worklist might clicable to get to the Procedure page
    Given Log with my "test" credentials
    When  Go to the worklist
    When  Click on the cell "datetime" for first procedure
    Then  The examination tab for "CHOCOLAT","TODAY_18:21" is opened
    And   Click on the worklist tab
    And   Click on the cell "patientId" for first procedure
    Then  The examination tab for "Chocolat","TODAY_18:21" is opened
    And   Click on the worklist tab
    When  Click on the cell "patientName" for first procedure
    Then  The examination tab for "Chocolat","TODAY_18:21" is opened
    And   Click on the worklist tab
    When  Click on the cell "birthDate" for first procedure
    Then  The examination tab for "Chocolat","TODAY_18:21" is opened
    And   Click on the worklist tab
    When  Click on the cell "alerts" for first procedure
    Then  The examination tab for "Chocolat","TODAY_18:21" is opened
    And   Click on the worklist tab
    When  Click on the cell "clearance" for first procedure
    Then  The examination tab for "Chocolat","TODAY_18:21" is opened
    And   Click on the worklist tab
    When  Click on the cell "scr" for first procedure
    Then  The examination tab for "Chocolat","TODAY_18:21" is opened
    And   Click on the worklist tab
    When  Click on the cell "procedureName" for first procedure
    Then  The examination tab for "Chocolat","TODAY_18:21" is opened
    And   Click on the worklist tab
    When  Click on the cell "accessNumber" for first procedure
    Then  The examination tab for "Chocolat","TODAY_18:21" is opened
    And   Click on the worklist tab
    When  Click on the cell "status" for first procedure
    Then  The examination tab for "Chocolat","TODAY_18:21" is opened





