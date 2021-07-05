package StepDefs.Modules.Toast;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Then;

public class Toast {
    @Then("^No toast error message should be displayed$")
    public void no_toast_error_message_should_be_displayed()  {
     Selenide.$(SelectorsHelpers.e2eSelector("toaster-error-standard"))
             .shouldNotBe(Condition.disabled);
    }

  @Then("^A toast error message \"([^\"]*)\" should be displayed$")
  public void a_toast_error_message_should_be_displayed(String text) throws Throwable {
    Selenide.$(SelectorsHelpers.e2eSelector("toaster-error-standard"))
        .shouldBe(Condition.visible);
    Selenide.$(SelectorsHelpers.e2eSelector("toaster-error-standard"))
        .shouldHave(Condition.value(text));
  }

}
