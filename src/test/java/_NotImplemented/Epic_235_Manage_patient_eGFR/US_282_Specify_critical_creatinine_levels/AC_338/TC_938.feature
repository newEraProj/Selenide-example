@Sprint3
  @TC_938
 Feature: AC_338 User must be able to define 5 different levels after choosing an unit
     Scenario:User must be able to define 5 different levels after choosing an unit
       Given Log with my "test" credentials
       Given Go to the configuration
       And   Open clinical parameters
       And   Go to creatinine levels screen
       And   Set creatinine unit to "µmol/L"
       When  Set the creatinine levels to "50" - "80" - "100" - "120"
       When   Set the creatinine levels to "80" - "50" - "95" - "120"
       Then  error message values should be ordered should be screened on creatinine screen
       When  Set the creatinine levels to "50" - "80" - "120" - "95"
       Then  error message values should be ordered should be screened on creatinine screen
       And    Set the creatinine levels to "50" - "50" - "95" - "120"
       Then   error message values should be ordered should be screened on creatinine screen
