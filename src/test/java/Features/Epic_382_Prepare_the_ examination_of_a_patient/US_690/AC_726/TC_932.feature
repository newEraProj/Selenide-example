@Sprint3
@TC_932
Feature: AC_726 An user might open an unique tab from the worklist

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

  Scenario: TC_932 An user might open an unique tab from the worklist
    Given Log with my "test" credentials
    Given Go to the worklist
    Given Select the station "Testra T74"
    Given Open the patient procedure "A0005"
    Then  Examination tab of procedure "A0005" is opened
    When  Click on the worklist tab
    Then  The worklist is displayed
    Then  The examination tab for "Chocolat" + "09/03/2020, 2:06 PM"is opened
    Given Open the patient procedure "A0005"
    Then  The examination tab for "Chocolat" + "09/03/2020, 2:06 PM"is opened


