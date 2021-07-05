@Epic_76
@US_77
@TC_180
Feature:  AC_467 Visualize the examination worklist

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities |
      | T001      | Banane    | Choсolat | 1949-09-30 | male   | 66.77  | 172    | unknown   | false         |                    |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
      | CTScan2    | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames      | fromRis |
      | CT           | Pro Auto | Testra T74;CTScan2 | false   |
    And Following procedures exist for station "CTScan2"
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0002        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_180  As a radiographer I want to See the examination worklist
    Given Log with my "test" credentials
    And   Go to the worklist
    And   Choose "Station CTScan2" station
    When  The worklist is displayed
    Then  Date time field should be displayed with value "2020-09-03T12:06:00Z" in the worklist
    Then  Patient ID field should be displayed with value "T001" in the worklist
    Then  Patient Name should be displayed with value "CHOCOLAT Banane" with the space between them and last name should be in capital in the worklist
    Then  Date of Birth field should be displayed with value "1949-09-30" in the worklist
    Then  Procedure name field should be displayed with value "Pro Auto" in the worklist
    Then  Acession Number field should be displayed with value "A0002" in the worklist
    Then  Status field should be displayed with value "planned" in the worklist
