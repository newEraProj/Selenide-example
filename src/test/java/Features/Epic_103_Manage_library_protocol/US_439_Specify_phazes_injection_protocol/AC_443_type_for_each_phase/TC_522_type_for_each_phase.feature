@Epic_103
@US_380
@TC_522
  Feature: AC_443 User might choose the type for each phase
    Background:
      Given Log with "test" IAM login
      And Database is empty
    Scenario: TC_522 User might choose the type for each phase
      Given Log with my "test" credentials
      And   Go to the configuration
      And   Go to examination parameters
      And   Go to Protocol management screen
      And   Click add new protocol on protocol management screen

      And   Add phase on protocol creation modal
      Then  There is no default value for product type in the phase on protocol creation modal
      When  Click on the types of injection product  in the phase on protocol creation modal
      Then  The following phase types should be presented : "Injection,OptiBolus,Wait,Pause,Timing Bolus,Test" on protocol creation screen
