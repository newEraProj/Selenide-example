package StepDefs.Modules.Configuration.ExaminationParameters;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;

public class Procedure_type {

    @Given("^Go to procedure types$")
    public void go_to_procedure_types() throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("examination-parameters")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("procedure-types")).click();
    }

    @Given("^Add new procedure type on procedure types screen$")
    public void add_new_procedure_type_on_procedure_types_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("config","menu" ,"page", "procedure-type-button-add")).click();
    }

    @When("^Set modality name to \"([^\"]*)\" on procedure types screen$")
    public void set_modality_name_to_on_procedure_types_screen(String arg1) {
        Selenide.$(SelectorsHelpers.e2eSelector("procedure-type-name")).clear();
        Selenide.$(SelectorsHelpers.e2eSelector("procedure-type-name")).sendKeys(arg1);
    }

    @When("^Set modality to \"([^\"]*)\" on procedure types screen$")
    public void set_modality_to_on_procedure_types_screen(String arg1) {
        Selenide.$(SelectorsHelpers.e2eSelector("procedure-type-modality")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "procedure-type-modality", "procedure-type-modality-" + arg1)).click();
    }

    @When("^Click save on procedure types screen$")
    public void click_save_on_procedure_types_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("save-button")).click();
    }

    @Then("^Procedure type named \"([^\"]*)\" should be visible on procedure types screen$")
    public void procedure_type_named_should_be_visible_on_procedure_types_screen(String name){
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page" ,"datagrid")).shouldHave(Condition.text(name));
    }

    @When("^Click on action for \"([^\"]*)\" on procedure types screen$")
    public void click_on_action_for_on_procedure_types_screen(String procedureName){
        boolean selected;
        selected = Selenide.$$(SelectorsHelpers.e2eSelector("config" ,"menu", "page", "datagrid", "row")).find(Condition.text(procedureName)).isDisplayed();
        if(selected) {
            Selenide.$(SelectorsHelpers.e2eSelector("config", "page", "datagrid", "row" )).find("button.datagrid-action-toggle").click();
        }
    }

    @Then("^The edit action should be disabled for procedure type named \"([^\"]*)\" on procedure types screen$")
    public void the_edit_action_should_be_disabled_for_procedure_type_named_on_procedure_types_screen(String arg1){
        Selenide.$(SelectorsHelpers.e2eSelector("config" ,"menu", "page", "datagrid", "row", "action-button-Edit")).shouldBe(Condition.disabled);
    }

    @Then("^The delete action should be disabled for procedure type named \"([^\"]*)\" on procedure types screen$")
    public void the_delete_action_should_be_disabled_for_procedure_type_named_on_procedure_types_screen(String arg1){
        Selenide.$(SelectorsHelpers.e2eSelector("config" ,"menu", "page", "datagrid", "row", "action-button-Delete")).shouldBe(Condition.disabled);

    }
}