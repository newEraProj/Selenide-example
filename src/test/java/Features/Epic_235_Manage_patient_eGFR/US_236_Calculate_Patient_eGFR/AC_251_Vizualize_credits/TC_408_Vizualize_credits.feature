@Sprint1
@TC_408
Feature: AC_251 User might visualize credits and help regarding formulas

  Scenario: TC_408 User might visualize credits and help regarding formulas
    Given Log with my "test" credentials
    And  Opens the eGFR calculation from a patient procedure page
    When Click on the CKD-EPI formula
    Then The popups screened hints of calculation



