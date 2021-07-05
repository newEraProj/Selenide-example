package StepDefs.Modules.Examination_screen;

import Helpers.SelectorsHelpers;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.*;

public class Scr_value_manually {
    @When("^Open clearance value manually$")
    public void open_clearance_value_manually(){
        Selenide.$(SelectorsHelpers.e2eSelector("tabs-list","clearance-add")).click();
    }
}
