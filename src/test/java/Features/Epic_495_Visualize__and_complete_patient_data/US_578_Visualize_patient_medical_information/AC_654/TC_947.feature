@Epic_495
@US_578
@TC_947
Feature: AC_654 The update date of the values must be retrieved from the RIS

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | firstName | lastName | birthDate  | gender | weight | height | pregnancy | breastfeeding | hypersensitivities | lastEgfrValues | lastScrValues |
      | T001      | Banane    | Chocolat | 1949-09-30 | female | 66.77  | 172    | unknown   | unknown       |                    |                |               |
    And Following stations exist
      | name       | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | Testra T74 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "Testra T74"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | A0005        | TODAY_15:00 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |

  Scenario:TC_947 The update date of the values must be retrieved from the RIS
    Given Log with my "test" credentials
    And  Go to the worklist
    And  Select the station "Testra T74" on worklist
    And  Open the patient procedure "A0005" on worklist
    Then The pregnancy risk should be enabled on patient procedure
    And  The pregnancy status should be "Unknown" on patient procedure
    And  The breastfeeding status should be "Unknown" on patient procedure
    And  The patient information "T001" should be enabled on patient procedure
    And  The patient weight should be "66.77" on patient procedure
    And  The patient height should be "172" on patient procedure
    When Set the pregnancy status at "No" on patient procedure
    And  Set the breastfeeding status at "No" on patient procedure
    And  Update the weight to "68.5" on patient procedure
    And  Update the height to "171" on patient procedure
    Then The pregnancy status should be "No" on patient procedure
    And  The breastfeeding status should be "No" on patient procedure
    And The patient weight should be "68.5" on patient procedure
    And The patient height should be "171" on patient procedure


    