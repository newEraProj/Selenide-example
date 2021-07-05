@Sprint3
@TC_823
Feature: AC_646 An user might edit a Station

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following stations exist
      | name    | modalityType | manufacturer | model | aetitleFilter | scheduledNameFilter | spsLocationFilter | modalityTypeFilter | injectors |
      | Test_01 | ASMT         | PHILIPS      | Y12   | false         | false               | false             | true               |           |

  Scenario: TC_823 An user might edit a Station
    Given Log with my "test" credentials
    And Go to stations library
    And Choose "Test_01" station
    And Click on edit station
    And All fields of edit station are editable
    And Change name of the station to "Test_01_Bis"
    And Save the changes on station edit screen
    Then  The name of the station have been edited
