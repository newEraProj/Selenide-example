package StepDefs.Sprint_3.US_643_Station_configuration.AC_644_User_can_create_a_station;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;

public class TC_819_User_can_create_a_station {
    @Given ("^Go to the station library, clik on add a station$")
    public void go_to_the_station_library_clik_on_add_a_station() {
        Selenide.$("[e2e-id='config-link']").click();
        Selenide.$("[e2e='stations-button-add']").click();
    }
    @When("^Scheduled Station AETitle is N by default   Modality type is Y by default     Scheduled Station Name is N by default     SpsLocation is N by default$")
    public void scheduled_Station_AETitle_is_N_by_default_Modality_type_is_Y_by_default_Scheduled_Station_Name_is_N_by_default_SpsLocation_is_N_by_default() {

    }
    @Then("^Set name = CTTest(\\d+), Select modality type = CT$")
    public void set_name_CTTest_Select_modality_type_CT(int arg1) {
        Selenide.$("[e2e-id~='station-form-basics-name']").sendKeys("CTtest3");
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basics-modality']").click();
    }

    @Then("^The modality type available are:  AR, ASMT, AU, BDUS, BI, BMD, CR, CT, CTPROTOCOL, DG, DOC, DX, ECG, EPS, ES, FID, GM, HC, HD, IO, IOL, IVOCT, IVUS, KER, KO, LEN, LS, MG, MR, M(\\d+)D, NM, OAM, OCT, OP, OPM, OPT, OPTBSV, OPTENF, OPV, OSS, OT, PLAN, PR, PT, PX, REG, RESP, RF, RG, RTDOSE, RTIMAGE, RTINTENT, RTPLAN, RTRECORD, RTSEGANN, RTSTRUCT, RWV, SEG, SM, SMR, SR, SRF, STAIN, TG, US, VA, XA, XC$")
    public void the_modality_type_available_are_AR_ASMT_AU_BDUS_BI_BMD_CR_CT_CTPROTOCOL_DG_DOC_DX_ECG_EPS_ES_FID_GM_HC_HD_IO_IOL_IVOCT_IVUS_KER_KO_LEN_LS_MG_MR_M_D_NM_OAM_OCT_OP_OPM_OPT_OPTBSV_OPTENF_OPV_OSS_OT_PLAN_PR_PT_PX_REG_RESP_RF_RG_RTDOSE_RTIMAGE_RTINTENT_RTPLAN_RTRECORD_RTSEGANN_RTSTRUCT_RWV_SEG_SM_SMR_SR_SRF_STAIN_TG_US_VA_XA_XC(int arg1) {
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsAR']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsASMT']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsAU']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsBDUS']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsBI']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsBMD']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsCR']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsCT']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsCTPROTOCOL']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsDG']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsDOC']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsDX']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsECG']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsEPS']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsES']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsFID']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsGM']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsHC']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsHD']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsIO']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsIOL']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsIVOCT']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsIVUS']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsKER']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsKO']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsLEN']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsLS']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsMG']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsMR']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsM3D']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsNM']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsOAM']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsOCT']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsOP']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsOPM']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsOPT']").isDisplayed();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsOPTBSV']").isDisplayed();


        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsCT']").click();
    }
    @Then("^Set Manufacturer = Toshiba; Manufacturers Model Name = PT(\\d+)$")
    public void set_Manufacturer_Toshiba_Manufacturers_Model_Name_PT(int arg1) {
        Selenide.$("[e2e-id~='station-form-manufacturer-name']").sendKeys("Toshiba");
        Selenide.$("[e2e-id~='station-form-manufacturer-model']").sendKeys("PT900");
    }
    @Then("^Select a PACS$")
    public void select_a_PACS() {
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basics-PACSYYY']").click();
    }
    @Then("^The associated PACS is selected from an enumeration\\. \"([^\"]*)\" is N by default$")
    public void the_associated_PACS_is_selected_from_an_enumeration_is_N_by_default(String arg1) {
        Selenide.$("[e2e~='station-form-pacs-toggle']").shouldNotBe(Condition.selected);
    }
    @Then("^Select a RIS$")
    public void select_a_RIS() {
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-ris-RISXXX']").click();
    }
    @Then("^The associated RIS is selected from an enumeration\\. \"([^\"]*)\" is N by default$")
    public void the_associated_RIS_is_selected_from_an_enumeration_is_N_by_default(String arg1) {
        Selenide.$("[e2e-id~='station-form-ris-toggle']").shouldNotBe(Condition.selected);
    }
    @Then("^Set \"([^\"]*)\" and \"([^\"]*)\" to YES$")
    public void set_and_to_YES(String arg1, String arg2) {
       // Selenide.$("[e2e-id~='station-form-pacs-toggle']").setSelected(true);
       // Selenide.$("[e2e-id~='station-form-ris-toggle']").selectOption("Yes");  need to find how to click on toggle button

    }

    @Then("^\"([^\"]*)\" and \"([^\"]*)\"  is a Yes/No button and could be set to Yes$")
    public void and_is_a_Yes_No_button_and_could_be_set_to_Yes(String arg1, String arg2) {
    }
    @Then("^save station CCTTest(\\d+)$")
    public void save_station_CCTTest(int arg1) {
        Selenide.$("[e2e-id~='save-button']").click();
    }
    @Then("^Create a new station name StationTest(\\d+), fill in all fields and set all filters for the worklist to No \\(ScheduledStation AETitle, Modalitytype, ScheduledStation Name, SpsLocation\\)$")
    public void create_a_new_station_name_StationTest_fill_in_all_fields_and_set_all_filters_for_the_worklist_to_No_ScheduledStation_AETitle_Modalitytype_ScheduledStation_Name_SpsLocation(int arg1) {
          Selenide.$("[e2e-id~='stations-button-add'").click();

        Selenide.$("[e2e-id~='station-form-basics-name']").sendKeys("СTTtest1");
        Selenide.$("[e2e-id~='station-form-manufacturer-name']").sendKeys("Toshiba");
        Selenide.$("[e2e-id~='station-form-manufacturer-model']").sendKeys("PT900");
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basicsCT']").click();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-basics-PACSYYY']").click();
        Selenide.$("[e2e-id~='config'][e2e-id~='station-form-ris-RISXXX']").click();

        Selenide.$("[e2e-id~='save-button']").click();




    }
    @Then("^The station Station Test(\\d+) is created$")
    public void the_station_Station_Test_is_created(int arg1) {
      //  Selenide.$("[e2e-id='config menu page stations datagrid row cell name']").isDisplayed(); need to change on exact station name

    }
    @Then("^Display the list of stations$")
    public void display_the_list_of_stations() {
        Selenide.$("[e2e-id='config menu page stations']").isDisplayed();
    }

    @Then("^Station name = CTTest(\\d+) and Station CTTest(\\d+) are created$")
    public void station_name_CTTest_and_Station_CTTest_are_created(int arg1, int arg2) {
        Selenide.$("[e2e-id='config menu page stations datagrid row cell CTTtest3']").shouldBe(Condition.visible);
    }
}
