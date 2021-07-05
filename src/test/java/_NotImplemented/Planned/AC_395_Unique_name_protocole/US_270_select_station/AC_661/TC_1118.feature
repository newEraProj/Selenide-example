@Sprint4
@TC_1118
@Select_the_station_to_filter_the_worklist
Feature:  AC_661 The system must only display the worklist associated to the selected station

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName  | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities | lastEgfrValues | lastScrValues |
      | T001      | Philippe   | Strassen | 1969-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
      | T002      | Marc       | Boiffort | 1949-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
      | T003      | JeanPierre | Koff     | 1990-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
      | T004      | Franck     | dubourg  | 2009-09-30 | male   | 66.77  | 172    | unknown   | unknown       |                    |                |               |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
      | CTScan2 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames   | fromRis |
      | CT           | Pro Auto | CTScan1;CTScan2 | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0001        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T003      | A0003        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following procedures exist for station "CTScan2"
      | patientId | accessNumber | datetime             | procedureType | procedureName    | physician   | note    | status  |
      | T002      | A0002        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
      | T004      | A0004        | 2020-09-03T12:06:00Z | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario: TC_1118 The system must only display the worklist associated to the selected station
    Given Log with my "test" credentials

    When Go to the worklist
    And Select the station "CTScan1"
    Then The procedure "A0001" should be displayed in worklist
    And The procedure "A0003" should be displayed in worklist
    And The procedure "A0002" should not be displayed in worklist
    And The procedure "A0004" should not be displayed in worklist
    And Injectors defined are displayed with the selected station "CTScan1"
    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0001"
    And Go to the worklist tab
    And Select the station "CTScan2"
    Then The tab of the opened procedure should be closed
    When Go to the worklist
    And Select the station "CTScan1"
    And Open the patient procedure "A0001"
    Then The station "CTScan1" should be displayed in procedure
    When Go to the worklist tab
    And Select the station "CTScan1"
    And Open the patient procedure "A0003"
    Then The station "CTScan1" should be displayed in procedure

