@Epic_103
@US_434
@TC_511
Feature: AC_470 An user might visualize the details of an injection protocol

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And    Following protocols exist
      | name | pediatricUse | peakPressureValue | peakPressureUnit | catheter | injectionDelay | scanDelay | concentrationValue | concentrationUnit | editionAuthor | editionDate | jsonlibrary                        | jsonfamily                  | jsonphases                                                                                                 |
      | Test | true         | 12                | bar              | 1        | 20             |           | 150                | mg/mL             | John Doe      | 2019-06-20  | {"id":"1","name": "Medex library"} | {"id":"1","name":"Cardiac"} | [{"type": "injection","product": "contrast","flowRate": 3,"volume": 10,"duration": 3,"contrastRate": 100}] |

  Scenario: TC_511 An user might visualize the details of an injection protocol
    Given Log with my "test" credentials

    Given Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Choose protocol "Test" on protocol management screen
    And   Click on edit the protocol "Test" on protocol management screen
    And   Set peak preassure value to "22" on protocol creation modal
    And   Save injection protocol on protocol creation modal
    When  Choose protocol "Test" on protocol management screen
    And   Click on edit the protocol "Test" on protocol management screen

    Then  Peak pressure value should be "22" on protocol creation modal

