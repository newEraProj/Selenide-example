@Epic_495
@US_580
@TC_942_Can_Select_hypersensibilities
Feature:  AC815 An user can add or delete an hypersensitivity
  #noinspection GherkinMisplacedBackground
  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following patients exist
      | patientId | name    | fisrtname | birthdate  | gender | weight | height | pregnancy | breastfeeding |
      | AN21023   | Simpson | Lisa      | 19/08/2014 | Female | 66.77  | 172    | unknown   | Unknown       |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | T001      | AN21023      | TODAY_18:21 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |


  Scenario: TC_942 An user can add or delete an hypersensitivity.
    Given Log with my "test" credentials
    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "AN21023" on worklist
    When Add an hypersensitivity "Optiray" on patient procedure
    Then The hypersensitivities block should displayed hypersensitivity "Optiray" on patient procedure
    When Add an hypersensitivity "Xenetix" on patient procedure
    Then The hypersensitivities block should displayed hypersensitivity "Xenetix" on patient procedure
    And The hypersensitivities block should displayed hypersensitivity "Optiray" on patient procedure
    When Remove from the hypersensitivity block the hypersensitivity "Xenetix" on patient procedure
    Then A confirmation pop-up should be displayed for removing the hypersensitivity on patient procedure
    When Cancel the remove from the hypersensitivity block on patient procedure
    Then The hypersensitivities block should displayed hypersensitivity "Xenetix" on patient procedure
    Then The hypersensitivities block should displayed hypersensitivity "Optiray" on patient procedure
    When Remove from the hypersensitivity block the hypersensitivity "Xenetix" on patient procedure
    And Confirm the remove from the hypersensitivity block on patient procedure
    Then The hypersensitivities block should not displayed hypersensitivity "Xenetix" on patient procedure
    Then The hypersensitivities block should displayed hypersensitivity "Optiray" on patient procedure
