@Epic_583
@US_584
@TC_4825
Feature: AC_4865
  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities |
      | T001      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |                    |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter |
      | Testra T74 | CT           | PHILIPS      | Y12   | true          | true                | true              | true               |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | Testra T74    | false   |
    And Following procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | AN_          | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: The default value "Generic procedure" shall exist in the list of procedure types.
    Given Log with my "test" credentials
    Given Go to the configuration
    And  Go to procedure types
    And  Add new procedure type on procedure types screen
    When Set modality name to "Generic Procedure" on procedure types screen
    When Set modality to "CT" on procedure types screen
    When Click save on procedure types screen

    And  Go to procedure types
    Then Procedure type named "Generic Procedure" should be visible on procedure types screen
    When Click on action for "Generic Procedure" on procedure types screen
    Then The edit action should be disabled for procedure type named "Generic Procedure" on procedure types screen
    Then The delete action should be disabled for procedure type named "Generic Procedure" on procedure types screen
