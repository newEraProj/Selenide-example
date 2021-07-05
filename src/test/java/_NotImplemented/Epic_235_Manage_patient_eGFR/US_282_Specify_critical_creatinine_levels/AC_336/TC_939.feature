@Sprint3
@TC_939
Feature: AC_336 User must be able to apply the changes

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

  Scenario:TC_947 The update date of the values must be retrieved from the RIS
    Given Log with my "test" credentials
    And   Go to the worklist
    And   Go to the configuration
    And   Open clinical parameters
    And   Go to creatinine levels screen
    And   Set creatinine unit to "µmol/L"
    When  Set the creatinine levels to "50" - "80" - "100" - "120"
    When  Go to the worklist
    And   Open the patient procedure "A0005"
    And   Open clearance value manually
    And   Set creatinine unit to "µmol/L"
    And   Add a creatinine value "49"
    Then  The clearance result is "red"
    And   Close the procedure "A0005"
    When  Open the patient procedure "A0005"
    And   Set creatinine unit to "µmol/L"
    And    Add a creatinine value  "90"
    Then   The clearance result is "green"
    And   Open the patient procedure "A0005"
    And   Set creatinine unit to "µmol/L"
    And    Add creatinine value  "80"
    Then   The clearance result "orange"
