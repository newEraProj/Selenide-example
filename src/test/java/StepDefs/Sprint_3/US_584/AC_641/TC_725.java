package StepDefs.Sprint_3.US_584.AC_641;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;


public class TC_725 {
    @Given("^Go to the configuration\\. Note the list of already added station and modality type\\. Note the station associated to CT$")
    public void go_to_the_configuration_Note_the_list_of_already_added_station_and_modality_type_Note_the_station_associated_to_CT() {
        Selenide.$("[e2e-id='config-link']").click();
        Selenide.$("[e2e='stations-button-add']").click();
        Selenide.$$(By.className("datagrid-row")).size();
    }

    @When ("^Go to the procedure library, create a new procedure set a modality$")
    public void go_to_the_procedure_library_create_a_new_procedure_set_a_modality() {
        Selenide.$("[e2e-id~='config'][e2e-id~='procedure-type-button-add']").click();
        Selenide.$("[e2e-id~='procedure-type-name'").should(Condition.be(Condition.visible).because("e2e-is missing in Procedure name field"));
    }
    @Then ("^Modality available in the list are the modality type noted at step (\\d+)$")
    public void modality_available_in_the_list_are_the_modality_type_noted_at_step(int arg1) {
    }
    @Then("^Choose the modality CT$")
    public void choose_the_modality_CT() {
    }
    @Then("^All station associated to CT are selected$")
    public void all_station_associated_to_CT_are_selected() {
    }
    @Then("^Set procedure type name = #Ceci_est_un_test-qui\\^-vérifie-que&-l’on-peut-@voir$")
    public void set_procedure_type_name_Ceci_est_un_test_qui_vérifie_que_l_on_peut_voir() {
    }
    @Then("^The new procedure is created\\. You can visualize the procedure with the folowing information: - Modality type = CT - Name of type procedure = #Ceci_est_un_test-qui\\^-vérifie-que&-l’on-peut-@voir$")
    public void the_new_procedure_is_created_You_can_visualize_the_procedure_with_the_folowing_information_Modality_type_CT_Name_of_type_procedure_Ceci_est_un_test_qui_vérifie_que_l_on_peut_voir() {
    }
}
