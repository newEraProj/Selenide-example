@Sprint2
@TC_575
Feature: AC_473   User must be able to enter an age  to distinguish adult from child
  Scenario: TC_575 User must be able to enter an age to distinguish adult from child
    Given Log with my "test" credentials
    And  Go to the configuration, set the age to distinguish adult from child to 18 years
    When  This age is set to 18 years for the current site for child
    Then  Change site, set the age to distinguish adult from child to 15 years
    And   This age is set to 15 years for the current site
    Then  Go back to the first site
    And  The age set is 18 years
    Then  Try to set 18.2 years
    And  The age set is 18 years
