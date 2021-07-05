package StepDefs.Sprint_3.US_584.AC_640;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;

public class TC_811 {

    @Given ("^Send a worklist \\(HL(\\d+) message\\) with a procedure name not availble in the procedure library \\(patient procedure (\\d+)\\)$")
    public void send_a_worklist_HL_message_with_a_procedure_name_not_availble_in_the_procedure_library_patient_procedure(int arg1, int arg2) {

        Selenide.$("[e2e-id='row cell procedureName'").should(Condition.have(Condition.text("")).because("In test condition you should retrive Worklist without procedure name"));
    }


    @When ("^Go to the procedure library, create a procedure with the procedure name, the modality and station of the procedure retrieve from the RIS \\(patient procedure (\\d+)\\)$")
    public void go_to_the_procedure_library_create_a_procedure_with_the_procedure_name_the_modality_and_station_of_the_procedure_retrieve_from_the_RIS_patient_procedure(int arg1) {
        Selenide.$("[e2e-id='config-link']").click();
        Selenide.$("[e2e-id='config menu procedure-types']").click();

    }

    @Then ("^In the library, edit the procedure: change the procedure name to Test(\\d+)$")
    public void in_the_library_edit_the_procedure_change_the_procedure_name_to_Test(int arg1) {
    }

    @Then ("^Go to the worklist, open the patient procedure (\\d+)$")
    public void go_to_the_worklist_open_the_patient_procedure(int arg1) {
    }

    @Then ("^The name of the procedure is Test(\\d+)$")
    public void the_name_of_the_procedure_is_Test(int arg1) {

    }
}
