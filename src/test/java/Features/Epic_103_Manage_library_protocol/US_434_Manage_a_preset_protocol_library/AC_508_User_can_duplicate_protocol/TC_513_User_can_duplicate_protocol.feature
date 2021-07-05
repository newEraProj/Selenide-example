@Epic_103
@US_434
@TC_513
  Feature: AC_508 An user might duplicate a protocol to create a new one
    Background:
      Given Log with "test" IAM login
      And Database is empty
      And    Following protocols exist
        | name | pediatricUse | peakPressureValue | peakPressureUnit | catheter | injectionDelay | scanDelay | concentrationValue | concentrationUnit | editionAuthor | editionDate | jsonlibrary                        | jsonfamily                  | jsonphases                                                                                                 |
        | Test | true         | 12                | bar              | 1        | 20             |           | 150                | mg/mL             | John Doe      | 2019-06-20  | {"id":"1","name": "Medex library"} | {"id":"1","name":"Cardiac"} | [{"type": "injection","product": "contrast","flowRate": 3,"volume": 10,"duration": 3,"contrastRate": 100}] |
    Scenario: TC_513 An user might duplicate a protocol to create a new one
      Given Log with my "test" credentials

      Given Go to the configuration
      And   Go to examination parameters
      And   Go to Protocol management screen
      And   Choose protocol "Test" on protocol management screen
      And   Click duplicate protocol "Test" on protocol management screen
      And   Set name to "Test1" on protocol creation modal
      When  Save protocol on protocol creation modal
      Then  Protocol "Test1" successfully saved on protocol management screen
