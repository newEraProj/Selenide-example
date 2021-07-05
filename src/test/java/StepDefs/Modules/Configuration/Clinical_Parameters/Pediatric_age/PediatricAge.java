package StepDefs.Modules.Configuration.Clinical_Parameters.Pediatric_age;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;

public class PediatricAge {
    @When("^Go to the other clinical parameters screen$")
    public void go_to_the_other_clinical_parameters_screen() {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "clinical-parameters")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("other-clinical-parameters")).click();
    }
    @When("^Set the max pediatric age to \"([^\"]*)\" on other clinical parameters screen$")
    public void set_the_max_pediatric_age_to_on_other_clinical_parameters_screen(String maxPediatricAge) {
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "max-pediatric-age")).click();
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "max-pediatric-age")).sendKeys(Keys.BACK_SPACE);
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page", "max-pediatric-age"))
                .setValue(maxPediatricAge);
    }
    @When("^Click save on other clinical parameters screen$")
    public void click_save_on_other_clinical_parameters_screen(){
        Selenide.$(SelectorsHelpers.e2eSelector("config", "menu", "page","save-button")).click();
    }
}


