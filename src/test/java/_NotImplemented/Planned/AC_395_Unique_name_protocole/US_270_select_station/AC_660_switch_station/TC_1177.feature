@Sprint4
@TC_1177
@Select_the_station_to_filter_the_worklist
Feature:  AC_660 User must be able to switch from a station to another from the worklist page

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities | lastEgfrValues | lastScrValues |
      | T001      | Philippe  | Strassen | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
      | T002      | Marc      | Boiffort | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
      | T004      | Franck    | dubourg  | 2009-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
      | CTScan2    | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames      | fromRis |
      | CT           | Pro Auto | Testra T74;CTScan2 | false   |
    And Following procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0005        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following procedures exist for station "CTScan2"
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | T002      | A0002        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T004      | A0004        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_1117 The system must only display the worklist associated to the selected station
    Given Log with my "test" credentials

    When Go to the worklist
    Then The station "Testra T74" should be displayed in station list
    And The station "CTScan2" should be displayed in station list

