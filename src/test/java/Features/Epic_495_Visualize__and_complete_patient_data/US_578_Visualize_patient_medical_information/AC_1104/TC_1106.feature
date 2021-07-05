@Epic_495
@US_578
@TC_1106
Feature: AC_1104 The update date of the values must be retrieved from the RIS

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName  | birthDate  | gender | weight | height | pregnancy | breastfeeding |
      | ID1106_01 | Chocolat  | Banane    | TODAY-35M  | male   | 65.77  | 172    | No        | No            |
      | ID1106_02 | Mangue    | Kiwi      | 2000-11-30 | female | 55.33  | 162    | unknown   | Yes           |
      | ID1106_03 | Citron    | Framboise | 1990-07-15 | other  |        |        | Yes       | Unknown       |
      | ID1106_04 | Orange    | Peche     | 1980-01-01 | female |        |        | unknown   | unknown       |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime             | procedureType | procedureName           | physician | note        | status  |
      | ID1106_01 | ATC1106_01   | 2019-09-09T15:30:00Z | Pro Auto      | CT Thorax with contrast | momo      | test note   | planned |
      | ID1106_02 | ATC1106_02   | 2019-12-12T07:00:00Z | Pro Auto      | MRI Chest with contrast |           |             | planned |
      | ID1106_03 | ATC1106_03   | 2019-10-10T19:15:00Z | Pro Auto      | CT cholographie         |           | test note 2 | planned |
      | ID1106_04 | ATC1106_04   | 2019-10-10T19:15:00Z | Pro Auto      | CT cholographie         |           | test note 2 | planned |

  Scenario:TC_1106 The update date of the values must be retrieved from the RIS
    Given Log with my "test" credentials

    When Go to the configuration
    And  Open other clinical parameters
    And  Set pediatric age to "17" years on other clinical parameters
    And  Save modification on other clinical parameters
    Then The pediatric age should be "17" years on other clinical parameters

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "ATC1106_01" on worklist
    And Add an hypersensitivity "Dotarem" on patient procedure
    Then BMI should not be available on patient procedure
    And The patient gender should be "male" on patient procedure
    And The pregnancy status should be "No" on patient procedure
    And The breastfeeding status should be "No" on patient procedure
    And The patient weight should be "65.77" on patient procedure
    And The hypersensitivities block should displayed hypersensitivity "Dotarem" on patient procedure
    And The patient height should be "172" on patient procedure
    And The patient name "Banane" firstname "Chocolat" should be displayed on patient procedure
    And The patient date of birth should be "TODAY-35M" on patient procedure
    And The patient age should be "35" "Months" on patient procedure
    And The patient id should be "ID1106_01" on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "ATC1106_02" on worklist
    And Add an hypersensitivity "Dotarem" on patient procedure
    And Add an hypersensitivity "Xenetix" on patient procedure
    Then BMI should be "21.08" on patient procedure
    And The patient gender should be "female" on patient procedure
    And The pregnancy status should be "Unknown" on patient procedure
    And The breastfeeding status should be "Yes" on patient procedure
    And The patient weight should be "55.33" on patient procedure
    And The hypersensitivities block should displayed hypersensitivity "Dotarem" on patient procedure
    And The hypersensitivities block should displayed hypersensitivity "Xenetix" on patient procedure
    And The patient height should be "162" on patient procedure
    And The patient name "Kiwi" firstname "Mangue" should be displayed on patient procedure
    And The patient date of birth should be "11/30/2000" on patient procedure
    And The patient id should be "ID1106_02" on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "ATC1106_03" on worklist
    Then BMI should not be available on patient procedure
    And The patient gender should be "other" on patient procedure
    And The pregnancy status should be "Yes" on patient procedure
    And The breastfeeding status should be "Unknown" on patient procedure
    And The patient weight should be "" on patient procedure
    And The hypersensitivities block should displayed none hypersensitivity on patient procedure
    And The patient height should be "" on patient procedure
    And The patient name "Framboise" firstname "Citron" should be displayed on patient procedure
    And The patient date of birth should be "07/15/1990" on patient procedure
    And The patient id should be "ID1106_03" on patient procedure

    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "ATC1106_04" on worklist
    Then BMI should not be available on patient procedure
    And The patient gender should be "female" on patient procedure
    And The pregnancy status should be "Unknown" on patient procedure
    And The breastfeeding status should be "Unknown" on patient procedure
    And The patient weight should be "" on patient procedure
    And The hypersensitivities block should displayed none hypersensitivity on patient procedure
    And The patient height should be "" on patient procedure
    And The patient name "Peche" firstname "Orange" should be displayed on patient procedure
    And The patient date of birth should be "01/01/1980" on patient procedure
    And The patient id should be "ID1106_04" on patient procedure


    