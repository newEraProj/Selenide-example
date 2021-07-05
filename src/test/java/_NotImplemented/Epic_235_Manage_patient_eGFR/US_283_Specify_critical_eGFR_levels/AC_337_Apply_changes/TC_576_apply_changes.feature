@Sprint2
@TC_576
Feature: AC_337 User must be able to apply the changes
    #noinspection GherkinMisplacedBackground
  Background:
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

  Scenario: TC_576 User must be able to apply the changes
    Given Log with my "test" credentials
    And  Go to the configuration, set the eGFR level to 30 - 60 - 90
    When Go to the worklist open a procedure (A01). Open the eGFR calculator.
    Then Set the height to 155 cm and serum to 188 umol/L. Save the result
    And The eGFR result is red
    Then Close the procedure A01
    And Open another procedure A02, open the eGFR calculator set the height to 170 cm and serum to 68.3 umol/L.
    Then The eGFR result is green
    And Open another C&C session with another user but do not close the first session. Go to the worklist
    Then On the first session, go to the configuration, change the eGFR level to 25 - 60 - 95
    And On the second session the eGFR of the procedure A01 is red and A02 is green
    Then On the second session, refresh the worklist
    And On the second session the eGFR of the procedure A01 is red and A02 is yellow
    Then Go to the first session, go to the worklist
    And On the first session the eGFR of the procedure A01 is red and A02 is yellow


