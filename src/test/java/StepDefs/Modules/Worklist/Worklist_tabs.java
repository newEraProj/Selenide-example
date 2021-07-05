package StepDefs.Modules.Worklist;

import Helpers.SelectorsHelpers;
import Helpers.UtilsDate;
import StepDefs.Model.Procedure;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;

public class Worklist_tabs {

    @Then("^The examination tab opens in the previous step is always opened$")
    public void the_examination_tab_opens_in_the_previous_step_is_always_opened() {
        Selenide.$(SelectorsHelpers.e2eSelector("examination-tab", "datetime")).shouldBe(Condition.visible);
    }

    @When("^Click on the worklist tab$")
    public void click_on_the_worklist_tab() {
        Selenide.$(SelectorsHelpers.e2eSelector("worklist-tab")).shouldBe(Condition.visible).click();
    }
    @Then("^The examination tab for \"([^\"]*)\",\"([^\"]*)\" is opened$")
    public void the_examination_tab_for_is_opened(String patientName, String datetime) {
        datetime = UtilsDate.getDateForBrowser(datetime);


        patientName = patientName.toUpperCase();
        Selenide.$(SelectorsHelpers.e2eSelector("examination-tab")).shouldBe(Condition.visible);
    }
    @When("^Close the examination tab on worklist$")
    public void close_the_examination_tab_on_worklist() {
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","close-tab")).click();
    }

    @Then("^No examination tab displayed$")
    public void no_examination_tab_displayed() {
        Selenide.$(SelectorsHelpers.e2eSelector("examination-tab", "datetime")).shouldBe(Condition.disappear);
    }

    @Then("^The tab of the opened procedure should be closed$")
    public void the_tab_of_the_opened_procedure_should_be_closed(){
        Selenide.$(SelectorsHelpers.e2eSelector("examination-tab"))
                .shouldNotBe(Condition.visible);
    }
}

