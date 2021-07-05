package StepDefs.Modules.Configuration.Clinical_Parameters.Clearance_Settings;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;

public class Clearance_settings_screen {

    @Given("^Set the creatinine levels to \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\"$")
    public void set_the_creatinine_level_to_(String arg1, String arg2, String arg3, String arg4) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-input-0")).setValue(arg1);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-input-1")).setValue(arg2);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-input-2")).setValue(arg3);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-input-3")).setValue(arg4);
    }

    @When("^Set creatinine unit to \"([^\"]*)\"$")
    public void set_creatinine_unit_to(String unit) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "scr-levels-select")).selectOptionContainingText(unit);
    }

    @Then("^error message values should be ordered should be screened on creatinine screen$")
    public void error_message_values_should_be_ordered_should_be_screened_on_creatinine_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-input-alert")).isDisplayed();
    }

    @When("^Save creatinine levels$")
    public void save_creatinine_levels() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "save-button")).click();
    }

    @When("^Discard all creatinine level changes$")
    public void discard_all_creatinine_level_changes() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "scr-levels-reset", "button")).click();

    }

    @Then("^Creatinine levels are ([^\"]*) - ([^\"]*) - ([^\"]*) - ([^\"]*)")
    public void creatinine_levels_are(String arg1, String arg2, String arg3, String arg4) {
        // Write code here that turns the phrase above into concrete actions
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-input-0")).shouldBe(Condition.value(arg1));
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-input-1")).shouldBe(Condition.value(arg2));
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-input-2")).shouldBe(Condition.value(arg3));
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-input-3")).shouldBe(Condition.value(arg4));
    }

    @Then("^Creatinine level unit choice is \"([^\"]*)\"$")
    public void creatinine_levels_unit_choice_are(String val1) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "scr-levels-select")).shouldHave(Condition.value("µmol/L")).isDisplayed();
    }

    @Then("^Creatinine levels unit choice are \"([^\"]*)\",\"([^\"]*)\"$")
    public void creatinine_levels_unit_choice_are_µmol_L_mg_dL(String val1, String val2) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "scr-levels-select"))
                .selectOption(val1);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "scr-levels-select"))
                .selectOption(val2);
// no more than  2 choices expected in the select
        Selenide.$$(By.cssSelector("[e2e-id='config menu page scr-levels-select'] option")).shouldHaveSize(2);
    }

    @Then("^Creatinine levels equivalence are \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\"$")
    public void creatinine_levels_equivalence_are(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-inputs-0")).shouldHave(Condition.value(arg1));
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-inputs-1")).shouldHave(Condition.value(arg2));
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-inputs-2")).shouldHave(Condition.value(arg3));
        Selenide.$(SelectorsHelpers.e2eSelector("config", "levels-inputs-3")).shouldHave(Condition.value(arg4));
    }


    @When("^Set validity period for creatinine \"([^\"]*)\"$")
    public void set_validity_period_for_creatinine(String arg1) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "validity-period")).sendKeys(arg1);
    }
        @When("^Open eGFR levels screen$")
        public void open_eGFR_levels_screen() {
            Selenide.$(SelectorsHelpers.e2eSelector("config","clinical-parameters")).click();
            Selenide.$(SelectorsHelpers.e2eSelector("config","egfr-levels")).click();
        }
        @When("^Set the eGFR value levels to \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
        public void set_the_eGFR_value_levels_to(String arg1, String arg2, String arg3){
            Selenide.$(SelectorsHelpers.e2eSelector("config","levels-input-0")).setValue(arg1);
            Selenide.$(SelectorsHelpers.e2eSelector("config","levels-input-1")).setValue(arg2);
            Selenide.$(SelectorsHelpers.e2eSelector("config","levels-input-2")).setValue(arg3);
        }
        @When("^Save eGFR levels$")
        public void save_eGFR_levels(){
            Selenide.$(SelectorsHelpers.e2eSelector("config","menu","page","save-button")).click();
        }
    @Given("^Open clearance settings screen$")
    public void open_clearance_settings_screen(){
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu","clinical-parameters")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config","menu", "clinical-parameters", "clearance-settings")).click();
    }

    @Then("^The procudure \"([^\"]*)\" should have \"([^\"]*)\" eGFR result$")
    public void the_procudure_should_have_eGFR_result(String procedureID, String color) {

        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "procedures", "datagrid", "row", "cell")).shouldHave(Condition.text(procedureID));
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list", "procedures", "clearance-color-" +color)).shouldHave(Condition.text(color));
    }

}





