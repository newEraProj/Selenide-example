@Epic_103
@US_434
@TC_509
Feature: AC_435 An user might delete an injection protocol

  Background:
    Given Log with "test" IAM login

    And    Following protocols exist
      | name | pediatricUse | peakPressureValue | peakPressureUnit | catheter | injectionDelay | scanDelay | concentrationValue | concentrationUnit | editionAuthor | editionDate | jsonlibrary                        | jsonfamily                  | jsonphases                                                                                                 |
      | Test | true         | 12                | bar              | 1        | 20             |           | 150                | mg/mL             | John Doe      | 2019-06-20  | {"id":"1","name": "Medex library"} | {"id":"1","name":"Cardiac"} | [{"type": "injection","product": "contrast","flowRate": 3,"volume": 10,"duration": 3,"contrastRate": 100}] |

  Scenario: TC_509 An user might delete an injection protocol
    Given Log with my "test" credentials
    Given Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Choose protocol "Test" on protocol management screen
    When  Click delete protocol "Test" on protocol management screen

    Then  A deletion pop-up should be displayed on protocol management screen
    When  Cancel deletion pop up on protocol management screen
    Then  The protocol "Test" should not be deleted on protocol management screen
    And   Click delete protocol "Test" on protocol management screen
    When  Confirm deletion pop-up on protocol management screen
    Then  The protocol "Test" should be deleted on protocol management screen
