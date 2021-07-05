@Sprint3
@Delete_station
  Feature: @AC_645 An user must be able to delete a station
    Scenario: @TC_819  An user must be able to delete a station
      Given Log with my "test" credentials
      And  Go to the station library. open a station and click on delete.
      When  A confirmation pop-up is displayed after click on delete station
      Then  Click on cancel
      And   The station isn't deleted
      Then  Click on delete and confirm the pop-up
      And   The station is deleted
