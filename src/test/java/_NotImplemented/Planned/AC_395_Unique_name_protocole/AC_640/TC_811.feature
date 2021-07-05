@Sprint3
@Retrive_procedure_type
  Feature: AC_640 The system must be able to retrieve procedure types from the RIS
  Scenario: TC_811 The system must be able to retrieve procedure types from the RIS
    Given Log with my "test" credentials
    #TODO review this scenario
    And  Send a worklist (HL7 message) with a procedure name not availble in the procedure library (patient procedure 1)
    When Go to the procedure library, create a procedure with the procedure name, the modality and station of the procedure retrieve from the RIS (patient procedure 1)
    Then In the library, edit the procedure: change the procedure name to Test28
    And  Go to the worklist, open the patient procedure 1
    Then  The name of the procedure is Test28
