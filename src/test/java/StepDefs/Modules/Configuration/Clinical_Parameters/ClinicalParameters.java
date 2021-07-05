package StepDefs.Modules.Configuration.Clinical_Parameters;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Given;
import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClinicalParameters {
    @Given("^Open clinical parameters$")
    public void open_clinical_parametrs(){
        Selenide.$(SelectorsHelpers.e2eSelector("config","clinical-parameters")).click();
    }


    @When("^Set pediatric age to \"([^\"]*)\" years$")
    public void set_pediatric_age_to_years(String age)  {
        Selenide.$(SelectorsHelpers.e2eSelector("config","menu", "page", "max-pediatric-age")).setValue(age); // set value
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "save-button")).click();            // SAVE

    }

    @Then("^The pediatric age is \"([^\"]*)\" years$")
    public void the_pediatric_age_is_years(String age) {
        Selenide.$(SelectorsHelpers.e2eSelector("config","menu", "page", "max-pediatric-age")).shouldBe(Condition
            .value(age));
    }

    @Given("^Open other clinical parameters$")
    public void open_other_clinical_parameters(){
        Selenide.$(SelectorsHelpers.e2eSelector("config","clinical-parameters")).click();
    }


    @When("^Set pediatric age to \"([^\"]*)\" years on other clinical parameters$")
    public void set_pediatric_age_to_years_on_other_clinical_parameters(String age)  {
        Selenide.$(SelectorsHelpers.e2eSelector("config","menu", "page", "max-pediatric-age")).setValue(age); // set value
    }

    @Then("^The pediatric age should be \"([^\"]*)\" years on other clinical parameters$")
    public void the_pediatric_age_should_be_years_on_other_clinical_parameters(String age){
        Selenide.$(SelectorsHelpers.e2eSelector("config","menu", "page", "max-pediatric-age")).shouldBe(Condition
            .value(age));
    }

    @When("^Save modification on other clinical parameters$")
    public void save_modification_on_other_clinical_parameters() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "save-button")).click();            // SAVE
    }

}
