package StepDefs.Modules.Worklist;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static Helpers.SelectorsHelpers.e2eSelector;
import static com.codeborne.selenide.Condition.*;

public class Worklist_content {



    @When("^Click on the cell \"([^\"]*)\" for first procedure")
    public void click_on_the_cell_for_first_procedure(String cell) {
    Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","worklist-tab-content","procedures","datagrid","row","cell"," "+cell)).click();
    }

    @Given ("^User checking field of last name$")
    public void user_checking_field_of_last_name() {
        Selenide.$(By.xpath("/html/body/app-root/div/div/main/app-procedures/div/app-data-grid/clr-datagrid/div[1]/div/div/div/div/div/div[2]/clr-dg-column[3]/div/button/span")).isDisplayed();
        //TODO review this test
    }
    @When("^User checking last name of the patient$")
    public void user_checking_last_name_of_the_patient() {
        Selenide.$$(By.className("upper")).filterBy(Condition.text("DOE"));
        //TODO review this test
    }

    @Then("^Worklist should contain \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void worklist_should_contain(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8){
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","column"+arg1));
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","column"+arg2));
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","column"+arg3));
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","column"+arg4));
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","column"+arg5));
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","column"+arg6));
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","column"+arg7));
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","column"+arg8));
    }
    @Then("^Patient last name is in capital letter \"([^\"]*)\"$")
    public void patient_last_name_is_in_capital_letter(String patientName){

        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","cell","patientName")).shouldHave(exactTextCaseSensitive(patientName));
    }

    @Given ("^User made an action in the application$")
    public void user_made_an_action_in_the_application() {
        Selenide.$("procedures datagrid row cell patient_id\"").click();
    }


    @Given("^User open app and verifying that eGFR column is presented$")
    public void user_open_app_and_verifying_that_eGFR_column_is_presented() {
        //TODO review this test
        Selenide.$("[e2e-id='procedures datagrid column clearance']").isDisplayed();
    }
    @When("^User checking that all colours are presented$")
    public void user_checking_that_all_colours_are_presented() {
        //TODO review this test
        Selenide.$(By.className("badge is-red")).isDisplayed();
        Selenide.$(By.className("badge is-yellow")).isDisplayed();
        Selenide.$(By.className("badge is-gray")).isDisplayed();
        Selenide.$(By.className("badge is-orange")).isDisplayed();
        Selenide.$(By.className("badge is-green")).isDisplayed();
    }
    @When("^the worklist is screened$")
    public void the_worklist_is_screened(){
        Selenide.$("procedures datagrid").isDisplayed();
        //TODO review this test
    }
    @Then("^Worklist should contain Date-Time,Patient ID,Patient Name,Date of birth,Clearance level,Access Number,Status columns$")
    public void worklist_should_contain_Date_Time_Patient_ID_Patient_Name_Date_of_birth_Clearance_level_Access_Number_Status_columns(){
        //TODO review this test
        Selenide.$("procedures datagrid column patient_id").isDisplayed();
        System.out.println("Column Patient ID is displayed");
        System.out.println("");
        Selenide.$("procedures datagrid column patient_name").isDisplayed();
        System.out.println("Column Patient Name is displayed");
        System.out.println("");
        Selenide.$("procedures datagrid column birth_date").isDisplayed();
        System.out.println("Column Date of birth is displayed");
        System.out.println("");
        Selenide.$("procedures datagrid column clearance").isDisplayed();
        System.out.println("Column Clearance is displayed");
        System.out.println("");
        Selenide.$("procedures datagrid column procedure_name").isDisplayed();
        System.out.println("Column Procedure name is displayed");
        System.out.println("");
        Selenide.$("procedures datagrid column access_number").isDisplayed();
        System.out.println("Column Accession number is presented");
        System.out.println("");
    }

    @Then("^The procedure \"([^\"]*)\" should be displayed in worklist$")
    public void the_procedure_should_be_displayed_in_worklist(String procedureAN) {
        Selenide.$$(SelectorsHelpers.e2eSelector("worklist-tab-content", "cell", "accessNumber")).find(Condition.text(procedureAN)).shouldBe(Condition.visible);
    }

    @Then("^The procedure \"([^\"]*)\" should not be displayed in worklist$")
    public void the_procedure_should_not_be_displayed_in_worklist(String procedureAN) {
    SelenideElement selector = Selenide.$$(e2eSelector("worklist-tab-content", "cell", "accessNumber")).find(Condition.text(procedureAN));
        Selenide.$(selector).shouldNot(exist);
    }

    @Then("^The station \"([^\"]*)\" should be displayed in station list$")
    public void the_station_should_be_displayed_in_station_list(String stationName) {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "worklist-tab-content", "procedures", "stations", "stations-input")).click();
        Selenide.$$(SelectorsHelpers.e2eSelector("tabs-list", "worklist-tab-content", "stations", "stations-list", "item")).find(Condition.text(stationName)).shouldBe(visible);
        // We need the second click to close the opened select to be again opened
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "worklist-tab-content", "procedures", "stations", "stations-input")).click();
    }
    }



