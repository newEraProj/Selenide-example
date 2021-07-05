@Epic_583
@Create_new_procedure_type
  Feature: @AC_641 The system must be able to retrieve procedure types from the RIS
  Scenario: @TC_725 The system must be able to retrieve procedure types from the RIS
    Given Log with my "test" credentials
    And   Go to the configuration. Note the list of already added station and modality type. Note the station associated to CT
    When  Go to the procedure library, create a new procedure set a modality
    Then  Modality available in the list are the modality type noted at step 1
    And   Choose the modality CT
    Then  All station associated to CT are selected
    And  Set procedure type name = #Ceci_est_un_test-qui^-vérifie-que&-l’on-peut-@voir
    And   The new procedure is created. You can visualize the procedure with the folowing information: - Modality type = CT - Name of type procedure = #Ceci_est_un_test-qui^-vérifie-que&-l’on-peut-@voir
