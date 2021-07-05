@Epic_235
@US_312
  @TC_465
  Feature: AC_313 User might be enter or edit manually patient's informations
    Background:
      Given Log with "test" IAM login
      And Database is empty
    Scenario: TC_465 User might be enter or edit manually patient's informations
      Given Log with my "test" credentials
      And    Go to the configuration
      And    Open clearance settings screen
      And  Set the eGFR value levels to "30","60","100"
      And  Set creatinine unit to "mg/dL"
      And  Set the creatinine levels to "30" - "60" - "90" - "100"
      And  Set validity period for creatinine "365"
      And  Save creatinine levels

       And  Go to the worklist
       When Open clearance calculation module
       Then Patient data should not exist

      When  Select the "MDRD" formula on clearance calculation module
      Then  The following field Birth date is available on clearance calculation module
      Then  The following  field Gender is available on clearance calculation module
      Then  The following  field African American is available on clearance calculation module
      Then  The following  field IDMS is available on clearance calculation module
      When  Set  Age to "35" years on clearance calculation module
      When  Set Gender to "female" on clearance calculation module
      When  Set Afro-American to "yes" on clearance calculation module
      When  Set IDMS to "yes" on clearance calculation module
      When  Set Serum unit to "mg/dL" on clearance calculation module
      When  Set Serum value to "0.86" on clearance calculation module
      When  Click compute eGFR value on clearance calculation module
      Then  The result value is "90.9" and unit is "mL/min/1.73m²" on clearance calculation module


      When  Select the "CKD-EPI" formula on clearance calculation module
      Then  The following field Birth date is available on clearance calculation module
      Then  The following  field Gender is available on clearance calculation module
      Then  The following  field African American is available on clearance calculation module
      When  Set Age to "50" years on clearance calculation module
      When  Set Gender to "Male" on clearance calculation module
      When  Set Afro-American to "yes" on clearance calculation module
      When  Set Serum unit to "mg/dL" on clearance calculation module
      When  Set Serum value to "2.01" on clearance calculation module
      When  Click compute eGFR value on clearance calculation module
      Then  The result value is "43.5" and unit is "mL/min/1.73m²" on clearance calculation module

      When  Select the "Bedside-Scwartz" formula on clearance calculation module
      Then  The following field Heist in cm is available on clearance calculation module
      When  Set Heist to "210,5" cm years on clearance calculation module
      Then  Height changed to "211"
      When  Set Serum unit to "mg/dL" on clearance calculation module
      When  Set Serum value to "0.86" on clearance calculation module
      When  Click compute eGFR value on clearance calculation module
      Then  The result value is "94" and unit is "mL/min/1.73m²" on clearance calculation module

      When  Select the "Cockroft-Gault" formula on clearance calculation module
      Then  The following field Birth date is available on clearance calculation module
      Then  The following  field Gender is available on clearance calculation module
      Then  The following  field Weight in kg is available on clearance calculation module
      When  Set Weight to "65.841" on clearance calculation module
      Then  Weight changed to "65.84"
      When  Set Age to "38" years on clearance calculation module
      When  Set Gender to "male" on clearance calculation module
      When  Set Weight to "65.91" on clearance calculation module
      When  Set Serum unit to "mg/dL" on clearance calculation module
      When  Set Serum value to "0.86" on clearance calculation module
      Then  The result value is "82.2" and unit is "mL/min/1.73m²" on clearance calculation module

