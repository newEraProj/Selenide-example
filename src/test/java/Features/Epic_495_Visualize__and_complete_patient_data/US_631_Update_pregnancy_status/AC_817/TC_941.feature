@Epic_495
@US_631
@TC_941
Feature: AC_817 The system shall let the user select whether the patient is pregnant

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | T001      | Banane    | Chocolat | 1949-09-30 | female | 66.77  | 172    | false     | false         |
      | T002      | Cerise    | Pomme    | 1949-09-30 | male   | 66.77  | 172    | false     | false         |
      | T003      | Jules     | Noix     | 1990-04-30 | other  | 50     | 150    | false     | false         |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | Testra T74    | false   |
    And Following procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0005        | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T002      | A0006        | TODAY_19:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T003      | A0007        | TODAY_20:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_941 The system shall let the user select whether the patient is pregnant
    Given Log with my "test" credentials

    And Go to the worklist
    And Select the station "Testra T74" on worklist
    And Open the patient procedure "A0005" on worklist
    Then The patient gender should be "Female" on patient procedure
    And The pregnancy status should be "No" on patient procedure
    When Set the pregnancy status at "Yes" on patient procedure
    Then A feedback message should be displayed on patient procedure
    And The pregnancy status should be "Yes" on patient procedure
    When Set the pregnancy status at "Unknown" on patient procedure
    Then A feedback message should be displayed on patient procedure
    And The pregnancy status should be "Unknown" on patient procedure

    When  Go to the worklist
    And Open the patient procedure "A0006" on worklist
    Then The pregnancy risk should be disabled on patient procedure
    And The pregnancy status should be "No" on patient procedure

    When Go to the worklist
    And Select the station "Testra T74" on worklist
    And Open the patient procedure "A0007" on worklist
    Then The patient gender should be "Other" on patient procedure
    And The pregnancy status should be "No" on patient procedure
    When Set the pregnancy status at "Yes" on patient procedure
    Then A feedback message should be displayed on patient procedure
    And The pregnancy status should be "Yes" on patient procedure
    When Set the pregnancy status at "Unknown" on patient procedure
    Then A feedback message should be displayed on patient procedure
    And The pregnancy status should be "Unknown" on patient procedure

