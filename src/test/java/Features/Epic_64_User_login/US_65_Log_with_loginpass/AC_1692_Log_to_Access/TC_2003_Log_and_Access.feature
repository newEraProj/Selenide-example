@Epic_64
@US_65
@TC_2003
Feature:  AC1692 log with my credentials login and password

  Background:
    Given Log with "test" IAM login

  Scenario: TC_2003 User enter his credential and access to Constrast care
    Given Log with my "test" credentials
    Then The user can access to Contrast Care
