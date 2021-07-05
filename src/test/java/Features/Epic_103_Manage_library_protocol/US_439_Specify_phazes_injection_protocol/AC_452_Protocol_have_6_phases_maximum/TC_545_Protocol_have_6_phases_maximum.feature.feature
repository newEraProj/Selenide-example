@Epic_103
@US_380
@TC_545
Feature: AC_452 Each injection protocol has 6 phases maximum

  Background:
    Given Log with "test" IAM login
    And Database is empty

  Scenario: TC_545 Each injection protocol has 6 phases maximum
    Given Log with my "test" credentials

    And   Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Click add new protocol on protocol management screen
    And   Add phase on protocol creation modal
    And   Add phase on protocol creation modal
    And   Add phase on protocol creation modal
    And   Add phase on protocol creation modal
    And   Add phase on protocol creation modal
    And   Add phase on protocol creation modal

    When Add 7 th phase on protocol creation modal
    Then You can't add more than 6 phases

      
