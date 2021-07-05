@Epic_495
@US_580
@TC_943
Feature:  AC814 The system shall let the user select hypersensitivities from the list of products name and family types

  Background:
    Given Log with "test" IAM login
    And Database is empty

    And Following patients exist
      | patientId | name    | fisrtname | birthdate  | gender | weight | height | pregnancy | breastfeeding |
      | AN21023   | Simpson | Lisa      | 19/08/2014 | Female | 66.77  | 172    | unknown   | unknown       |
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter |
      | CTScan1 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |
    And Following procedures type exist
      | modalityType | name     | stationsNames | fromRis |
      | CT           | Pro Auto | CTScan1       | false   |
    And Following procedures exist for station "CTScan1"
      | patientId | accessNumber | datetime    | procedureType | procedureName    | physician   | note    | status  |
      | AN21023   | A0001        | TODAY_12:06 | Pro Auto      | PROCEDURE X45K12 | Dr Jacobsen | Nothing | planned |
    And Following products exist
      | code       | concentrationUnit | concentrationValue | container | family     | name    | type     | validityDate | volume |
      | 6768420006 | mmol/mL           | 100                | syringe   | Gadolinium | OPTIRAY | contrast | 2020-01-01   | 125    |

  Scenario: TC_943 The system shall let the user select hypersensitivities from the list of products name and family types
    Given Log with my "test" credentials
    When Go to the worklist
    And Select the station "CTScan1" on worklist
    And Open the patient procedure "A0001" on worklist

    And Click on Add an hypersensitivity
    Then The user can select hypersensitivities
      | Optiray |






