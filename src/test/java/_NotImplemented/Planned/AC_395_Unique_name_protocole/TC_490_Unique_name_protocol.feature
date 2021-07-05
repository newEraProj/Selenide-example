@Epic_103
@US_380
@TC_490
Feature: AC_395 User must be able to define an unique name for the suggested protocol

  Background:
    Given Log with "test" IAM login
    And Database is empty
    And Following protocol exist
      | Name | minWeight | maxWeight | ProcedureTypes | peakPreassureValue | peakPreassureUnit | type      | product  | flowrate | volume |
      | Test | 10        | 20        | test           | 12                 | psi               | injection | Contrast | 12       | 12     |

  Scenario: TC_490 User must be able to define a name
    Given Log with my "test" credentials
    And  Go to the configuration
    And  Go to examination parameters
    And  Go to Protocol management screen
    And  Click add new protocol on protocol management screen

