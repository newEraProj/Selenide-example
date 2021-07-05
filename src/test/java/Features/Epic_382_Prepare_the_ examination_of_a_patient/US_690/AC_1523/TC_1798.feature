@Epic_382
@US_690
@TC_1798
Feature:  AC_1523 Retrieve procedure information from RIS

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName  | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities | lastEgfrValues | lastScrValues |
      | TC_1798_1 | Chocolat  | Banane    | 1969-09-30 | male   | 66.77  | 172    | unknown   | No            |                    |                |               |
      | TC_1798_2 | Mangue    | Kiwi      | 1989-09-30 | other  | 59.77  | 185    | unknown   | No            |                    |                |               |
      | TC_1798_3 | Citron    | Framboise | 1998-09-30 | female | 56     | 156    | unknown   | No            |                    |                |               |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter |  injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |            |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime             | procedureType | procedureName           | physician | note        | status  |
      | TC_1798_1 | A0001        | 2019-09-09T15:30:00Z | Pro Auto      | CT Thorax with contrast | momo      | test note   | planned |
      | TC_1798_2 | A0002        | 2019-12-12T07:00:00Z | Pro Auto      | MRI Chest with contrast |           |             | planned |
      | TC_1798_3 | A0003        | 2019-10-10T19:15:00Z | Pro Auto      | CT cholographie         |           | test note 2 | planned |

  Scenario: TC_1798 Retrieve procedure information from RIS
    Given Log with my "test" credentials

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist
    Then The patient name "BANANE Chocolat" should be displayed on patient procedure
    And The procedure description "CT Thorax with contrast" should be displayed on patient procedure
    And The procedure access number "A0001" should be displayed on patient procedure
    And The procedure date "09/09/2019 15:30" should be displayed on patient procedure
    And The procedure physician "momo" should be displayed on patient procedure
    And The procedure note "test note" should be displayed on patient procedure
    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0002" on worklist
    Then The patient name "KIWI Mangue" should be displayed on patient procedure
    And The procedure description "MRI Chest with contrast" should be displayed on patient procedure
    And The procedure access number "A0002" should be displayed on patient procedure
    And The procedure date "12/12/2019 07:00" should be displayed on patient procedure
    And The procedure physician "" should be displayed on patient procedure
    And The procedure note "" should be displayed on patient procedure
    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0003" on worklist
    Then The patient name "FRAMBOISE Citron" should be displayed on patient procedure
    And The procedure description "CT cholographie" should be displayed on patient procedure
    And The procedure access number "A0003" should be displayed on patient procedure
    And The procedure date "10/10/2019 19:15" should be displayed on patient procedure
    And The procedure physician "" should be displayed on patient procedure
    And The procedure note "test note 2" should be displayed on patient procedure

