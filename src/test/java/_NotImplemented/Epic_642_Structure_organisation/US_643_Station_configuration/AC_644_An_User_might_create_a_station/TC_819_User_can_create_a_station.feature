@Sprint3
@TC_819
Feature: AC_650 User able to display list of stations
  Background:
    Given Log with "test" IAM login
    And Database is empty
  Scenario: TC_819 Create a stations
    Given Log with my "test" credentials
    And Go to stations library
    And   Add new station
    And   Set station "CTTest1"as name of the station
    And   The modality type available are:  AR, ASMT, AU, BDUS, BI, BMD, CR, CT, CTPROTOCOL, DG, DOC, DX, ECG, EPS, ES, FID, GM, HC, HD, IO, IOL, IVOCT, IVUS, KER, KO, LEN, LS, MG, MR, M3D, NM, OAM, OCT, OP, OPM, OPT, OPTBSV, OPTENF, OPV, OSS, OT, PLAN, PR, PT, PX, REG, RESP, RF, RG, RTDOSE, RTIMAGE, RTINTENT, RTPLAN, RTRECORD, RTSEGANN, RTSTRUCT, RWV, SEG, SM, SMR, SR, SRF, STAIN, TG, US, VA, XA, XC
    And   Set Manufacturer "Toshiba"
    And   Set Manufacturers Model Name "PT900"
    And   Set "Use this PACS as a destination" to "Yes"
    And   Set "Use this RIS as a destination" to "Yes"
    And   Save station "CCTTest1"
    And   Display the list of stations
    Then  Station name "CTTest1" is created
