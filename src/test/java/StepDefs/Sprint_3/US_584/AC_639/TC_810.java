package StepDefs.Sprint_3.US_584.AC_639;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;

public class TC_810 {
    @Given("^Go to the procedure library, create a procedure : modality CT; procedure name= Test(\\d+), select a station$")
    public void go_to_the_procedure_library_create_a_procedure_modality_CT_procedure_name_Test_select_a_station(int arg1) {
        Selenide.$("[e2e-id='config-link']").click();
        Selenide.$("[e2e-id='config menu procedure-types']").click();
        Selenide.$("[e2e-id~='config'][e2e-id~='procedure-type-button-add']").click();
        Selenide.$("[e2e-id~='procedure-type-name'").should(Condition.be(Condition.visible).because("e2e-is missing in Procedure name field"));
    }

    @When("^In the worklist create a procedure patient accession number A(\\d+), select the procedure Test(\\d+)\\. Close the procedure$")
    public void in_the_worklist_create_a_procedure_patient_accession_number_A_select_the_procedure_Test_Close_the_procedure(int arg1, int arg2) {

    }

    @Then("^Create another procedure patient accession number A(\\d+), select the procedure Test(\\d+)\\. Do not close the procedure$")
    public void create_another_procedure_patient_accession_number_A_select_the_procedure_Test_Do_not_close_the_procedure(int arg1, int arg2) {
    }

    @Then("^Go to the procedure library, select the procedure Test(\\d+) click on Edit\\. Change the procedure name to Test(\\d+) and station to MRI$")
    public void go_to_the_procedure_library_select_the_procedure_Test_click_on_Edit_Change_the_procedure_name_to_Test_and_station_to_MRI(int arg1, int arg2){

    }

    @Then("^Changes are saved$")
    public void changes_are_saved() {
    }

    @Then("^In the worklist open the procedure A(\\d+)$")
    public void in_the_worklist_open_the_procedure_A(int arg1) {
    }

    @Then("^The procedure A(\\d+) is Test(\\d+), modality CT$")
    public void the_procedure_A_is_Test_modality_CT(int arg1, int arg2) {
    }

    @Then("^The procedure A(\\d+) is Test(\\d+), modality MR$")
    public void the_procedure_A_is_Test_modality_MR(int arg1, int arg2) {
    }



}