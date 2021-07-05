@Sprint1
@TC_381
Feature: AC_248 The input data must be included in specified range data

  Scenario Outline: TC_381 input data must be included in specified range data
    Given Log with my "test" credentials
    And  Open the eGFR calculation
    When   The data input  <Formula> formula,"<Date of Birth>" date of Birth,"<Gender>" gender,"<Race>" race,"<IDMS>" iDMS,"<Height>" height,"<Weight>" weight,"<Serum Creatinine>" Serum creatinine,"<Serum Value mg/dL>" Serum value mg/dL,"<Serum Value umol/L>" Serum Value umol/L
    Then  To return "<value to return red>" value to return red

    Examples:

      | Formula                                 | Date of Birth | Gender | Race | IDMS | Height | Weight | Serum Creatinine | Serum Value mg/dL | Serum Value umol/L | value to return red |
      | //*[@id="clr-form-control-1"]/option[3] | 08/12/1850    | Male   | Yes  | N/A  | N/A    | N/A    | mg/dl            | 0,85              | N/A                | Age(years           |
      | //*[@id="clr-form-control-1"]/option[1] | 08/13/1889    | Female | Yes  | Yes  | N/A    | N/A    | 0,85             | 0,85              | N/A                | Age(month)          |
      | //*[@id="clr-form-control-1"]/option[4] | 08/12/1889    | Female | N/A  | N/A  | N/A    | 600    | mg/dL            | 7,5               | N/A                | Weight              |
      | //*[@id="clr-form-control-1"]/option[2] | 0/0/0         | N/A    | N/A  | N/A  | 280    | N/A    | mg/dL            | 0,85              | N/A                | Height              |
      | //*[@id="clr-form-control-1"]/option[1] | 08/12/1889    | Female | No   | N/A  | N/A    | N/A    | mg/dL            | 0                 | N/A                | Serum Value mg/dL   |
