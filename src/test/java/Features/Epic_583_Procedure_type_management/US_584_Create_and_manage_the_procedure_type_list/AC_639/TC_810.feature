@Epic_583
@US_584
@TC_810
Feature: AC_639 User must be able to edit a protocol

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following protocols exist
      | name       | pediatricUse | stations | procedureTypes | injectorModels | peakPressureValue | peakPressureUnit | catheter | injectionDelay | scanDelay | concentrationValue | concentrationUnit | editionAuthor | editionDate | jsonlibrary                        | jsonfamily                  | jsonphases                                                                                                 |
      | Protocol 1 | true         |          |                |                | 12                | bar              | 1        | 20             |           | 150                | mg/mL             | John Doe      | 2019-06-20  | {"id":"1","name": "Medex library"} | {"id":"1","name":"Cardiac"} | [{"type": "injection","product": "contrast","flowRate": 3,"volume": 10,"duration": 3,"contrastRate": 100}] |

  Scenario: TC_810 User must be able to edit a protocol
    Given Log with my "test" credentials
    Given Go to the configuration
    And   Go to examination parameters
    And   Go to Protocol management screen
    And   Choose protocol "Protocol 1" on protocol management screen
    And   Edit protocol on protocol management screen

    And   Set name to "Test1" on protocol creation modal
    And   Set peak pressure value to "14" on protocol creation modal
    And   Add phase to protocol on protocol creation modal

    And   Set "optibolus" type of protocol on protocol creation modal
    And   Set "c+s" as product of phase on protocol creation modal
    And   Set "12" as flowrate of phase on protocol creation modal
    And   Set "13" as volume of phase on protocol creation modal
    And   Set "30" as contrast of phase on protocol creation modal
    And   Save protocol on protocol creation modal
    Then  Protocol "Test1" should be saved on protocol management screen

