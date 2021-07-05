@Epic_103
@US_434
@TC_510
Feature: AC_436 An user might edit an injection protocol

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following protocols exist
      | name | pediatricUse | weightRange                        | stations  | injectorModels  | procedureTypes | peakPressureValue | peakPressureUnit | catheter | injectionDelay | scanDelay | concentrationValue | concentrationUnit | phases                                                                                                     | editionAuthor | editionDate | library                            | family                      |
      | Test | true         | {"minWeight":"1","maxWeight":"90"} | [1,2,3,4] | [3,11,8,2,9,10} | [2,1]          | 12                | bar              | 1        | 20             |           | 150                | mg/mL             | [{"type": "injection","product": "contrast","flowRate": 3,"volume": 10,"duration": 3,"contrastRate": 100}] | John Doe      | 2019-06-20  | {"id":"1","name": "Medex library"} | {"id":"1","name":"Cardiac"} |

  Scenario: TC_510 An user might edit an injection protocol
    Given Log with my "test" credentials
    Given Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Choose protocol "Test" on protocol management screen
    And   Click on edit the protocol "Test" on protocol management screen
    And   Set flowrate to "6" on protocol creation modal
    And   Set volume to "24" on protocol creation modal
    And   Save injection protocol
    And   Choose protocol "Test" on protocol management screen
    When  Click on edit the protocol "Test" on protocol management screen

    Then  Flowrate value should be "6" on protocol creation modal
    Then  Volume should be "24" on protocol creation modal

