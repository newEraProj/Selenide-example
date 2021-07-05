@Sprint2
@User_able_to_save_protocol
  Feature: @AC_458 User must be able to save the protocol
    Scenario: @TC_503 User must be able to save the protocol
      Given Log with my "test" credentials
      And Go to the protocol library, create a patient protocol
      When  Fill in all fields exept peak pressure and try to save the protocol
      Then  The protocol couldn't be saved
      And   Fill in all fields exept the name of the protocol and try to save the protocol
      Then  The protocol couldn't be saved
      And   Fill in the name and the peak pressure value. Add a phase select phase type injection and fill in all fields exept Flowrate. Try to save the protocol
      Then  The protocol couldn't be saved
      And   Select phase type Test and fill in all fields exсept Flowrate. Try to save the protocol
      Then  The protocol couldn't be saved
      And   Select phase type OptiBolus and fill in all fields exсept Flowrate. Try to save the protocol
      Then  The protocol couldn't be saved
      And   Select phase type Timing Bolus and fill in all fields exсept Flowrate. Try to save the protocol
      Then  The protocol couldn't be saved
      And   Select phase type injection and fill in all fields exсept Volume. Try to save the protocol
      Then  The protocol couldn't be saved
      And   Select phase type Test and fill in all fields exсept Volume. Try to save the protocol
      Then  The protocol couldn't be saved
      And   Select phase type OptiBolus and fill in all fields exсept Volume. Try to save the protocol
      Then  The protocol couldn't be saved
      And   Select phase type Timing Bolus and fill in all fields exсept Volume. Try to save the protocol
      Then  The protocol couldn't be saved
      And   Select phase type WAIT, fill in all fields. Try to save the protocol
      Then  The protocol couldn't be saved
      And   Select phase type Pause, fill in all fields. Try to save the protocol
      Then  The protocol couldn't be saved
      And   Select phase type Injection, fill in all fields. Add a second phase Pause and fill in all fields exept Duration. Try to save the protocol
      Then  The protocol couldn't be saved
      And   On the second phase select phase type Wait
      Then  The protocol is saved
