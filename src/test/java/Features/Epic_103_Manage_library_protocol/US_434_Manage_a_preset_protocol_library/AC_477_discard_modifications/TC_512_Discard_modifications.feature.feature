@Epic_103
@US_434
@TC_512
Feature: AC_477 An user might discard his modifications

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And    Following protocols exist
      | name | pediatricUse | peakPressureValue | peakPressureUnit | catheter | injectionDelay | scanDelay | concentrationValue | concentrationUnit | editionAuthor | editionDate | jsonlibrary                        | jsonfamily                  | jsonphases                                                                                                 |
      | Test | true         | 12                | bar              | 1        | 20             |           | 150                | mg/mL             | John Doe      | 2019-06-20  | {"id":"1","name": "Medex library"} | {"id":"1","name":"Cardiac"} | [{"type": "injection","product": "contrast","flowRate": 3,"volume": 10,"duration": 3,"contrastRate": 100}] |

  Scenario: TC_512 An user might discard his modifications
    Given Log with my "test" credentials

    Given Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Choose protocol "Test" on protocol management screen
    And   Click on edit the protocol "Test"
    And   Set peak preassure value to "22" on protocol creation modal
    And   Set name to "Test1" on protocol creation modal
    And   Set flowrate to "6" on protocol creation modal

    When  Click on Undo modification on protocol creation modal
    Then  A confirmation pop-up is displayed
    When  Click on Cancel on confirmation of edition pop-up
    Then  The flowrate value is presented and should be "6"
    Then  The name of protocol is presented and equals to "Test"
    When  Click on Confirm on confirmation of edition pop-up
    Then  The value of peak pressure should be "12" on protocol creation modal
    Then  The name of the protocol should be "Test" on protocol creation modal
    Then  The flowrate should be "3" on protocol creation modal


