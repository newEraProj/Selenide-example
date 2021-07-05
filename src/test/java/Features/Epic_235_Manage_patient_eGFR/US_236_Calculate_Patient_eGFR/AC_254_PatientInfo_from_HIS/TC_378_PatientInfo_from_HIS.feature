@Sprint1
@TC_378
Feature: AC_254 Patient's information might be retrieved from HIS and displayed

  Scenario: TC_378 Patient's information might be retrieved from HIS and displayed
    Given Log with my "test" credentials
    And Send a worklist (HL message) : 2 procedures (A0001, Male, Date of birth = today - 35 years -10 months, 85 kg, 175 cm)
    When The information belows are already display - Age : 35 years     - Weight : 85 kg - Height: 175 cm     - Gender : Male
    And  Send a worklist (HL7 message)  (A0002, Female, date of birth= today-76 years, 23 pound, 5,4 feet)
    Then The information below are already display - Age : 76 years  - Weight : 23 pd - Height: 5.4 ft  - Gender : Female


