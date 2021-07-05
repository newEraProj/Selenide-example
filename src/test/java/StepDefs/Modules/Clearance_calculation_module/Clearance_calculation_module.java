package StepDefs.Modules.Clearance_calculation_module;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.By;

import static Helpers.SelectorsHelpers.e2eSelector;
import static com.codeborne.selenide.Selenide.$;

public class Clearance_calculation_module {
    @When("^Open clearance calculation module$")
    public void open_clearance_calculation_module() {
        $(e2eSelector("egfr-link")).click();
    }

    @Then("^Patient data should not exist$")
    public void patient_data_should_not_exist() {
        Selenide.$(SelectorsHelpers.e2eSelector("scr-value")).shouldBe(Condition.empty);
        Selenide.$(SelectorsHelpers.e2eSelector("age")).shouldBe(Condition.empty);

    }

    @When("^Select the \"([^\"]*)\" formula on clearance calculation module$")
    public void select_the_formula_on_clearance_calculation_module(String method) {
        Selenide.$(SelectorsHelpers.e2eSelector("method" + method)).click();
    }

    @Then("^The following field Birth date is available on clearance calculation module$")
    public void the_following_field_Birth_date_is_available_on_clearance_calculation_module() {
        Selenide.$(SelectorsHelpers.e2eSelector("age")).isDisplayed();
    }

    @Then("^The following  field Gender is available on clearance calculation module$")
    public void the_following_field_Gender_is_available_on_clearance_calculation_module() {
        Selenide.$(By.className("clr-control-label")).isDisplayed();
    }

    @Then("^The following  field African American is available on clearance calculation module$")
    public void the_following_field_African_American_is_available_on_clearance_calculation_module() {
        Selenide.$(SelectorsHelpers.e2eSelector("african-american-container")).isDisplayed();
    }

    @Then("^The following  field IDMS is available on clearance calculation module$")
    public void the_following_field_IDMS_is_available_on_clearance_calculation_module() {
        Selenide.$(SelectorsHelpers.e2eSelector("idms-container")).isDisplayed();


    }
}

