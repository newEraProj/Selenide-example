package StepDefs.Sprint_3.US_584.AC_638;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;

public class TC_728 {


    @Given ("^Go to the procedure list\\. Open a procedure and click on delete$")
    public void go_to_the_procedure_list_Open_a_procedure_and_click_on_delete( ) {
        Selenide.$("[e2e-id='config-link']").click();
        Selenide.$("[e2e-id='config menu procedure-types']").click();
        Selenide.$("clr-dg-action-overflow").click(); // 3  dots button with (delete,edit options)
        Selenide.$("[e2e-id~='config'][e2e-id~='action-button-Delete']").click();

        }
    @When("^A confirmation pop-up is displayed after clicking delete procedure$")
    public void a_confirmation_pop_up_is_displayed_after_clicking_delete_procedure() {
        Selenide.$("div.modal.body").isDisplayed();
    }
    @When("^Click on Cancel button$")
    public void click_on_Cancel_button() {
        Selenide.$("[e2e-id~='config'][e2e-id~='cancel-button']").click();
    }
    @Then("^The procedure isn't deleted$")
    public void the_procedure_isn_t_deleted() {
        Selenide.$("[e2e-id~='config'][e2e-id~='cell procedureTypeName']").isDisplayed();
    }
    @Then("^Click on delete and Confirm$")
    public void click_on_delete_and_Confirm(){
        Selenide.$("clr-dg-action-overflow").click();
        Selenide.$("[e2e-id~='config'][e2e-id~='action-button-Delete']").click();
        Selenide.$("[e2e-id~='config'][e2e-id~='ok-button']").click();
    }
    @Then("^The procedure is deleted$")
    public void the_procedure_is_deleted() {
        Selenide.$$(By.className("datagrid-host")).shouldHave(CollectionCondition.size(1).because("There was 2 procedurs and after deleting  should be 1 "));


    }


}
