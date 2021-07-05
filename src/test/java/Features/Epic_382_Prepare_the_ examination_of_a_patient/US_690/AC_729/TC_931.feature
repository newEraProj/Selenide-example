@Sprint3
@TC_931
Feature: AC_729 An user might close an examination tab

  Background:
    Given Log with "test" IAM login
    And Database is empty
    Given Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities | lastEgfrValues | lastScrValues |
      | T001      | Banane    | Chocolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | Testra T74    | false   |
    And Following procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0005        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_931 An user might close an examination tab
    Given Log with my "test" credentials
    Given Go to the worklist
    Given Select the station "Testra T74"
    Given Open the patient procedure "A0005"
    Then  Examination tab of procedure "A0005" is opened
    When  Close the examination tab on worklist
    Then  No examination tab displayed

