@Sprint2
@TC_481
Feature: AC_430 Setup default clearance computation method based on the age of the patient (Adult, Child)

  Scenario: TC_481 Setup default clearance computation method based on the age
    Given Log with my "test" credentials
    And Go to the configuration, set the limit age adult/patient to 15 years
    When This limit age has been configured / A list is display to select the default formula for adult / A list is display to select the default formula for child
    Then Select the default eGFR formula to MDRD for adult
    And  Select the default eGFR formula to Bedside Schwartz for child
    Then Go to the patient procedure of a patient with a date of birth DD/MM/YYYY-16 with DD/MM/YYYY today date. Open the eGFR calculator from this procedure one
    And The default formula is MDRD. The limit age adult / peadia is displayed
    And  Go to the patient procedure of a patient with a date of birth DD+1/MM/YYYY-16 with DD/MM/YYYY today date. Open the eGFR calculator from this procedure two
    Then The default formula is MDRD. The limit age adult / peadia is displayed
    And  Go to the patient procedure of a patient with a date of birth DD-1/MM/YYYY-16 with DD/MM/YYYY today date. Open the eGFR calculator from this procedure three
    Then The default formula is Bedside Schwartz

